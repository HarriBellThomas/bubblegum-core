package io.hbt.bubblegum.core;

import io.hbt.bubblegum.core.auxiliary.NetworkDetails;
import io.hbt.bubblegum.core.auxiliary.logging.LoggingManager;
import io.hbt.bubblegum.core.databasing.MasterDatabase;
import io.hbt.bubblegum.core.exceptions.AddressInitialisationException;
import io.hbt.bubblegum.core.exceptions.BubblegumException;
import io.hbt.bubblegum.core.exceptions.MalformedKeyException;
import io.hbt.bubblegum.core.kademlia.BubblegumNode;
import io.hbt.bubblegum.core.kademlia.NodeID;
import io.hbt.bubblegum.core.kademlia.activities.ActivityExecutionContext;
import io.hbt.bubblegum.core.kademlia.activities.LookupActivity;
import io.hbt.bubblegum.core.kademlia.activities.PingActivity;
import io.hbt.bubblegum.core.kademlia.router.RouterNode;
import io.hbt.bubblegum.core.social.SocialIdentity;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Bubblegum {

    private InetAddress ipAddress;
    private SocialIdentity socialIdentity;
    private ActivityExecutionContext executionContext;
    private ArrayList<BubblegumCell> cells;
    private HashMap<String, BubblegumNode> nodes;

    private boolean isAlive = false;
    private boolean isShuttingDown = false;

    public Bubblegum() {

        try {
            this.initialiseIPAddress();
            this.initialiseSocialIdentity();
            this.executionContext = new ActivityExecutionContext(0);
            this.cells = new ArrayList<>();
            this.nodes = new HashMap<>();

            //this.loadNodes();
            this.isAlive = true;

//        } catch (AddressInitialisationException e) {
//            System.out.println("Failed to start network");
        }
        catch (BubblegumException e) {
            e.printStackTrace();
        }
    }

    private void loadNodes() {
        Set<NetworkDetails> networks = MasterDatabase.getInstance().loadNetworksFromDatabase();
        int newProcesses = 0;
        for(NetworkDetails network : networks) {
            if(this.nodes.containsKey(network.id)) continue;
            try {
                NodeID id = new NodeID(network.hash);
                BubblegumNode.Builder reloadedNodeBuilder = new BubblegumNode.Builder();
                reloadedNodeBuilder.setIdentifier(network.id);
                reloadedNodeBuilder.setNetworkIdentifier(network.network);
                reloadedNodeBuilder.setNodeIdentifier(id);
                reloadedNodeBuilder.setPort(network.port);
                reloadedNodeBuilder.setSocialIdentity(this.socialIdentity);
                reloadedNodeBuilder.setExecutionContext(this.executionContext);
                reloadedNodeBuilder.setLogger(LoggingManager.getLogger(network.id));
                BubblegumNode reloadedNode = this.insertIntoCell(reloadedNodeBuilder);

                newProcesses++;
                this.nodes.put(network.id, reloadedNode);
            }
            catch (MalformedKeyException e) {
                System.out.println("Failed to load network - " + network.hash);
                continue;
            }
        }

        this.executionContext.newProcessesInContext(newProcesses);
    }

    private void initialiseIPAddress() throws AddressInitialisationException {
        try {
            this.ipAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new AddressInitialisationException();
        }
    }

    public List<BubblegumNode> buildNodes(int numNodes) {
        List<BubblegumNode> nodes = new ArrayList<>();
        for(int i = 0; i < numNodes; i++) nodes.add(this.createNode());

        return nodes;

//        MasterDatabase mdb = MasterDatabase.getInstance();
//        mdb.updateNetworks(this.nodes.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList()));
    }


    public BubblegumNode createNode() {
        UUID identifier = UUID.randomUUID();
        this.executionContext.newProcessInContext();
        BubblegumNode.Builder newNodeBuilder = new BubblegumNode.Builder();
        newNodeBuilder.setIdentifier(identifier.toString());
        newNodeBuilder.setSocialIdentity(this.socialIdentity);
        newNodeBuilder.setExecutionContext(this.executionContext);
        newNodeBuilder.setLogger(LoggingManager.getLogger(identifier.toString()));
        BubblegumNode newNode = this.insertIntoCell(newNodeBuilder);

        this.nodes.put(identifier.toString(), newNode);
        MasterDatabase mdb = MasterDatabase.getInstance();
        mdb.updateNetwork(newNode);
        return newNode;
    }

    private void initialiseSocialIdentity() {
        this.socialIdentity = new SocialIdentity();
    }

    private BubblegumNode insertIntoCell(BubblegumNode.Builder node) {
        BubblegumNode result = null;
        int i = 0;
        while(result == null && i < this.cells.size()) {
            result = this.cells.get(i).registerNode(node);
            i++;
        }

        if(result == null) {
            // Need to create new cell
            try {
                BubblegumCell newCell = new BubblegumCell(0, this.executionContext);
                this.cells.add(newCell);
                result = newCell.registerNode(node);

            } catch (BubblegumException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /* API */

    public Set<String> getNodeIdentifiers() {
        return this.nodes.keySet();
    }

    public BubblegumNode getNode(String identifier) {
        return this.nodes.get(identifier);
    }

    public void reset() {
        MasterDatabase.getInstance().resetDatabases();
        this.nodes.clear();
    }


    public static void main(String[] args) {
        Bubblegum bb = new Bubblegum();
        BubblegumNode _1 = bb.createNode();
        System.out.println("1: " + _1.getIdentifier());
        BubblegumNode _2 = bb.createNode();
        System.out.println("2: " + _2.getIdentifier());
        BubblegumNode _3 = bb.createNode();
        System.out.println("3: " + _3.getIdentifier());
        BubblegumNode _4 = bb.createNode();
        System.out.println("4: " + _4.getIdentifier());

//        PingActivity pingActivity = new PingActivity(_1, new RouterNode(_2.getNodeIdentifier(), _2.getServer().getLocal(), _2.getServer().getPort()), _2.getRecipientID());
////        pingActivity.run();
//////        if(pingActivity.getSuccess())
////
////        PingActivity pingActivity2 = new PingActivity(_1, new RouterNode(_3.getNodeIdentifier(), _3.getServer().getLocal(), _3.getServer().getPort()), _3.getRecipientID());
////        pingActivity2.run();
////
////        PingActivity pingActivity3 = new PingActivity(_1, new RouterNode(_4.getNodeIdentifier(), _4.getServer().getLocal(), _4.getServer().getPort()), _4.getRecipientID());
////        pingActivity3.run();
////
////        LookupActivity lookupActivity = new LookupActivity(_1, _1.getNodeIdentifier(), 5, false);
////        lookupActivity.run();

        System.out.println();
    }


//        HashMap<String, String> values = new HashMap<>();
//        values.put("abc", "xyz");
//        values.put("if you're happy", "and you know it");
//        values.put("clap your", "hands");
//        values.put("test", "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, `and what is the use of a book,' thought Alice `without pictures or conversation?'");
//        values.put("test2", "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, `and what is the use of a book,' thought Alice `without pictures or conversation?'");
//        values.put("test3", "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, `and what is the use of a book,' thought Alice `without pictures or conversation?'");
//        values.put("test4", "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, `and what is the use of a book,' thought Alice `without pictures or conversation?'");
//        values.put("test5", "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, `and what is the use of a book,' thought Alice `without pictures or conversation?'");
//        values.put("test6", "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, `and what is the use of a book,' thought Alice `without pictures or conversation?'");
//        values.put("test7", "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, `and what is the use of a book,' thought Alice `without pictures or conversation?'");
//        values.put("test8", "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, `and what is the use of a book,' thought Alice `without pictures or conversation?'");
//        values.put("test9", "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, `and what is the use of a book,' thought Alice `without pictures or conversation?'");
//        values.put("test10", "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, `and what is the use of a book,' thought Alice `without pictures or conversation?'");
//
//        long startTime = System.nanoTime();
//        for(Map.Entry<String, String> entry : values.entrySet()) {
//            System.out.println("-----");
//            long storeStart = System.nanoTime();
//            boolean accepted = first.store(NodeID.hash(entry.getKey()), entry.getValue().getBytes());
//            long storeEnd = System.nanoTime();
//            System.out.println("("+(storeEnd - storeStart)/1000000+"ms)");
//
//            if(accepted) {
//                System.out.println("Stored [" + entry.getKey() + " -> " + entry.getValue() + "]");
//
//                long lookupStart = System.nanoTime();
//                byte[] result = first.lookup(NodeID.hash(entry.getKey()));
//                long lookupEnd = System.nanoTime();
//                System.out.println("("+(lookupEnd - lookupStart)/1000000+"ms)");
//
//                if(result != null) {
//                    System.out.println("Lookup (" + entry.getKey() + ") = " + new String(result));
//                }
//                else {
//                    System.out.println("Lookup failed");
//                }
//            }
//            else {
//                System.out.println("Rejected [" + entry.getKey() + " -> " + entry.getValue() + "]");
//            }
//        }
//        long endTime = System.nanoTime();
//
//        System.out.println("\n" + values.size() + " operations took " + (endTime-startTime)/1000000 + "ms");
//    }

}




/**
 *
 * https://stackoverflow.com/questions/19329682/adding-new-nodes-to-kademlia-building-kademlia-routing-tables
 *
 * http://gleamly.com/article/introduction-kademlia-dht-how-it-works
 *
 * PING probes a node to see if it’s online.
 *
 * STORE instructs a node to store a [key, value] pair for later retrieval
 *
 * FIND NODE takes a 160-bit key as an argument, the recipient of the FIND_NODE RPC returns information for the k nodes closest to the target id.
 *
 * FIND VALUE behaves like FIND_NODE returning the k nodes closest to the target Identifier with one exception – if the RPC recipient has received a STORE for the key, it just returns the stored value
 *
 */





/**




 int numberOfNodes = 200;
 ActivityExecutionContext context = new ActivityExecutionContext(numberOfNodes);
 LoggingManager loggingManager = LoggingManager.getInstance();

 BubblegumNode[] nodes = new BubblegumNode[numberOfNodes];
 for(int i = 0; i < numberOfNodes; i++) {
 nodes[i] = BubblegumNode.construct(this.socialIdentity, context, loggingManager.getLogger(i), this.ipAddress, 44000 + i);
 }
 System.out.println();

 //         Bootstrap all nodes to node 0
 for(int i = 1; i < numberOfNodes; i++) {
 System.out.println(i);
 nodes[i].bootstrap(this.ipAddress, 44000);
 }

 System.out.println("Initial network built.\n");

 BubblegumNode newcomer = BubblegumNode.construct(this.socialIdentity, context, loggingManager.getLogger(numberOfNodes), this.ipAddress, 44000 + numberOfNodes);
 try {
 Thread.sleep(1000);
 loggingManager.getLogger(numberOfNodes + "").logMessage("Starting bootstrap");
 newcomer.bootstrap(this.ipAddress, 44034);

 RouterNode node0 = new RouterNode(
 new NodeID(nodes[0].getIdentifier().toString()),
 nodes[0].getServer().getLocal(),
 nodes[0].getServer().getPort()
 );

 byte[] b = new byte[20];
 new Random().nextBytes(b);
 System.out.println("Saving payload: " + Arrays.toString(b));

 NodeID storeKey = new NodeID();

 StoreActivity storeActivity = new StoreActivity(newcomer, storeKey.toString(), b);
 //            PrimitiveStoreActivity storeActivity = new PrimitiveStoreActivity(newcomer, node0, nodes[0].getIdentifier().toString(), b);
 storeActivity.run();



 System.out.println("Starting value lookup:");
 LookupActivity getval = new LookupActivity(newcomer, storeKey, 5, true);
 getval.run();

 if(getval.getComplete() && getval.getSuccess()) {
 System.out.println("Success.");
 if(getval.getResult() != null && getval.getResult().length > 0) {
 System.out.println(Arrays.toString(getval.getResult()));
 }
 else {
 System.out.println("No result...");
 }
 }
 else {
 System.out.println("Failed.");
 }

 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 catch (MalformedKeyException e) {
 e.printStackTrace();
 }

 NodeID closest = null;

 for(BubblegumNode bn : nodes) {
 if(closest == null) closest = bn.getIdentifier();
 else {
 byte[] o1Distance = newcomer.getIdentifier().xorDistance(bn.getIdentifier());
 byte[] o2Distance = newcomer.getIdentifier().xorDistance(closest);
 if(new BigInteger(1, o1Distance).abs().compareTo(new BigInteger(1, o2Distance).abs()) < 0) {
 // o1 bigger than o2
 //                    System.out.println("New closest");
 //                    System.out.println(new BigInteger(1, o1Distance).abs());
 //                    System.out.println("smaller than ");
 //                    System.out.println(new BigInteger(1, o2Distance).abs());
 closest = bn.getIdentifier();
 }
 }
 }
 System.out.println("Closest is " + closest.toString());

 while(true) {

 }



 */
package io.hbt.bubblegum.core.kademlia.activities;

import io.hbt.bubblegum.core.kademlia.BubblegumNode;
import io.hbt.bubblegum.core.kademlia.router.RouterNode;

import java.util.function.Consumer;

public class BootstrapActivity extends NetworkActivity {

    Consumer<String> networkIDUpdate;
    public BootstrapActivity(BubblegumNode self, RouterNode to, Consumer<String> networkIDUpdate) {
        super(self, to);
        this.networkIDUpdate = networkIDUpdate;
    }


    @Override
    public void run() {
        // Ping
        this.print("Starting bootstrapping process...  ("+this.to.getIPAddress().getHostAddress()+":"+this.to.getPort()+")");
        PingActivity ping = new PingActivity(this.localNode, this.to);
        ping.run();

        this.print("Bootstrap: Finished Initial Ping");

        if(ping.getComplete()) {
            // Was a success, now bootstrapped. getNodes from bootstrapped node
            if(ping.getNetworkID() != null) this.networkIDUpdate.accept(ping.getNetworkID());

            LookupActivity lookupActivity = new LookupActivity(this.localNode, this.localNode.getIdentifier(), 5, false);
            lookupActivity.run();

            this.complete = true;
            this.success = (lookupActivity.getComplete() && lookupActivity.getSuccess());

//            FindActivity findNodes = new FindActivity(this.localNode, this.to, this.localNode.getIdentifier().toString(), false);
//            findNodes.run();
//
//            if(findNodes.getComplete()) {
//                Set<KademliaNode> foundNodes = findNodes.getFindNodeResults();
//                for(KademliaNode node : foundNodes) {
//                    RouterNode routerNode = this.localNode.getRoutingTable().fromKademliaNode(node);
//                    if(routerNode != null) {
//                        RouterNode destination = this.routingTable.getRouterNodeForID(this.to.getNode());
//                        if(destination == null || !destination.isFresh()) {
//                            PingActivity nodePing = new PingActivity(this.localNode, routerNode);
//                            this.localNode.getExecutionContext().addPingActivity(this.localNode.getIdentifier().toString(), nodePing);
//                        }
//                    }
//                }
//
//                this.localNode.getExecutionContext().addDelayedActivity(
//                        this.localNode.getIdentifier().toString(),
//                        () -> this.localNode.getRoutingTable().refreshBuckets(),
//                        10000
//                );
//
//                this.complete = true;
//            }
//
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }

        else {
            this.print("No response from bootstrap node.");
        }
    }
}

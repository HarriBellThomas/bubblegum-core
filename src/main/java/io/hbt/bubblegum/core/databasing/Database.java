package io.hbt.bubblegum.core.databasing;

import io.hbt.bubblegum.core.kademlia.BubblegumNode;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private HashMap<String, HashMap<String, List< byte[]>>> db;

    private static Database instance;
    private static ContentDatabase cdbInstance;
    private static MasterDatabase masterDatabase;

    protected static final String DB_FOLDER_PATH = ".databases/";

    private Database() {
        this.db = new HashMap<>();
        Database.cdbInstance = ContentDatabase.getInstance();
        Database.masterDatabase = MasterDatabase.getInstance();
    }

    public synchronized static Database getInstance() {
        if(Database.instance == null) Database.instance = new Database();
        return Database.instance;
    }

    public Database(BubblegumNode localNode) {

//        Connection connection = null;
//        try
//        {
//            this.checkDatabasesDirectory();
//
            // create a databasing connection
//            connection = DriverManager.getConnection("jdbc:sqlite:.databases/" + this.localNode.getNodeIdentifier().toString() + ".db");
//            Statement statement = connection.createStatement();
//            statement.setQueryTimeout(30);  // set timeout to 30 sec.

//            statement.executeUpdate("drop table if exists person");
//            statement.executeUpdate("create table person (id integer, name string)");
//            statement.executeUpdate("insert into person values(1, 'leo')");
//            statement.executeUpdate("insert into person values(2, 'yui')");
//            ResultSet rs = statement.executeQuery("select * from person");
//            while(rs.next())
//            {
//                // read the result set
//                System.out.println("name = " + rs.getString("name"));
//                System.out.println("id = " + rs.getInt("id"));
//            }
//        }
//        catch(SQLException e)
//        {
//            // if the error message is "out of memory",
//            // it probably means no databasing file is found
//            System.err.println(e.getMessage());
//            e.printStackTrace();
//        }
//        finally
//        {
//            try {
//                if(connection != null) connection.close();
//            }
//            catch(SQLException e) {
//                // connection close failed.
//                System.err.println(e);
//                e.printStackTrace();
//            }
//        }

    }

    public Map<Integer, List<NetworkDetails>> loadNetworksFromDatabase() {
        return Database.masterDatabase.loadNetworksFromDatabase();
    }

    public void updateNodeInDatabase(BubblegumNode node) {
        Database.masterDatabase.updateNetwork(node);
    }

    public void updateNodesInDatabase(List<BubblegumNode> nodes) {
        Database.masterDatabase.updateNetworks(nodes);
    }

    public boolean hasKey(String node, String key) {
        if(!this.db.containsKey(node)) return false;
        else return this.db.get(node).containsKey(key);
    }

    public List<byte[]> valueForKey(String node, String key) {
        if(!this.db.containsKey(node)) return null;
        else return this.db.get(node).get(key);
    }

    public boolean add(String node, String key, byte[] value) {
        if(!this.db.containsKey(node)) this.db.put(node, new HashMap<>());
        if(!this.db.get(node).containsKey(key)) this.db.get(node).put(key, new ArrayList<>());
        if(!this.db.get(node).get(key).contains(value)) this.db.get(node).get(key).add(value);
        this.print("[Database] Saved " + key + " -> " + Arrays.toString(value));
        return true;
    }

    public Post savePost(BubblegumNode node, String content) {
        return Database.cdbInstance.savePost(node, content);
    }

    public Post getPost(BubblegumNode node, String id) {
        return Database.cdbInstance.getPost(node, id);
    }

    public List<Post> getAllPosts(BubblegumNode node) {
        return Database.cdbInstance.getPosts(node);
    }

    public List<Post> queryPosts(BubblegumNode node, long from, long to, List<String> ids) {
        return Database.cdbInstance.queryPosts(node, from, to, ids);
    }

    private void checkDatabasesDirectory() {
        File directory = new File(".databases");
        if (! directory.exists()) directory.mkdir();
    }

    public void reset() {
        // TODO finish
        Database.masterDatabase.resetDatabases();
    }

    private void print(String msg) {
//        this.localNode.log(msg);
    }
}

package io.hbt.bubblegum.core.kademlia.router;

import io.hbt.bubblegum.core.exceptions.MalformedKeyException;
import io.hbt.bubblegum.core.kademlia.BubblegumNode;
import io.hbt.bubblegum.core.kademlia.NodeID;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class RoutingTable {

    private final BubblegumNode self;
    private final RouterBucket[] buckets;

    public RoutingTable(BubblegumNode self) {
        this.self = self;
        this.buckets = new RouterBucket[NodeID.KEY_BIT_LENGTH];
        for(int i = 0; i < NodeID.KEY_BIT_LENGTH; i++) this.buckets[i] = new RouterBucket(i);
    }

    public void insert(RouterNode node) {
//        System.out.println("inserting into routing table: " + node.toString());
        this.getBucketForNode(node.getNode()).add(node);
    }

    public RouterBucket getBucketForNode(NodeID node) {
        int index = this.self.getIdentifier().sharedPrefixLength(node) - 1;
//        System.out.println("index: " + index);
        if(index < 0) return this.buckets[0];
        else return this.buckets[index];
    }

    public Set<RouterNode> getNodesClosestToKey(NodeID node, int nodesToGet) {
        return this.getNodesClosestToKeyWithExclusions(node, nodesToGet, new HashSet<>());
    }

    public Set<RouterNode> getNodesClosestToKeyWithExclusions(String node, int nodesToGet, Set<String> exclusions) {
        try {
            return this.getNodesClosestToKeyWithExclusions(new NodeID(node), nodesToGet, exclusions);
        } catch (MalformedKeyException e) {
            return new HashSet<>();
        }
    }

    public Set<RouterNode> getNodesClosestToKeyWithExclusions(NodeID node, int nodesToGet, Set<String> exclusions) {
        TreeSet<RouterNode> nodeDistanceTree = new TreeSet<>(node.getKeyDistanceComparator());
        HashSet<RouterNode> results = new HashSet<>();

        for(RouterBucket bucket : this.buckets) {
            nodeDistanceTree.addAll(bucket.getNodes());
        }

        Iterator<RouterNode> distanceTreeIterator = nodeDistanceTree.iterator();
        int i = 0;
        while(distanceTreeIterator.hasNext() & i < nodesToGet) {
            RouterNode n = distanceTreeIterator.next();
            // System.out.println(new BigInteger(1, node.xorDistance(n.getIdentifier())));
            if(!exclusions.contains(n.getNode().toString())) {
                results.add(n);
                i++;
            }
        }

        return results;
    }

    public void printBuckets() {
        for(RouterBucket bucket : this.buckets) {
            System.out.println(bucket.toString());
        }
    }
}
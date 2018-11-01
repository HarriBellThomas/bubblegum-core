package io.hbt.bubblegum.core.kademlia.activities;

import co.paralleluniverse.fibers.Suspendable;
import io.hbt.bubblegum.core.exceptions.MalformedKeyException;
import io.hbt.bubblegum.core.kademlia.BubblegumNode;
import io.hbt.bubblegum.core.kademlia.NodeID;
import io.hbt.bubblegum.core.kademlia.router.RouterNode;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

public class StoreActivity extends SystemActivity {

    final private String key;
    final private byte[] value;

    public StoreActivity(BubblegumNode localNode, String key, byte[] value) {
        super(localNode);
        this.key = key;
        this.value = value;
    }

    @Override
    @Suspendable
    public void run() {
        this.print("\n\nStarting STORE");
        try {
            NodeID storeIdentifier = new NodeID(key);
            LookupActivity lookupActivity = new LookupActivity(this.localNode, storeIdentifier, 5, false);
            lookupActivity.run();

            if(lookupActivity.getComplete() && lookupActivity.getSuccess()) {
                this.print("LOOKUP completed\n");
                // was a success
                Set<RouterNode> results = lookupActivity.getClosestNodes();
                if(!results.isEmpty()) {

                    StringBuilder sb = new StringBuilder();
                    sb.append("STORE chosen nodes:\n");
                    int numAccepted = 0;
                    for(RouterNode node : results) {
                        sb.append("  --- " + node.getNode().toString());
                        PrimitiveStoreActivity storeActivity = new PrimitiveStoreActivity(this.localNode, node, this.key, this.value);
                        storeActivity.run();
                        if(storeActivity.getComplete() && storeActivity.getSuccess()) {
                            numAccepted++;
                            sb.append(" (Accepted)\n");
                        }
                        else {
                            sb.append("  (Rejected)\n");
                        }
                    }

                    if(numAccepted > 0) {
                        sb.append(numAccepted + " nodes accepted STORE("+this.key+" -> "+ Arrays.toString(this.value) +")");
                        this.onSuccess(sb.toString());
                    }
                    else {
                        sb.append("All nodes rejected the STORE");
                        this.onFail(sb.toString());
                    }
                }
                else {
                    this.onFail("STORE: LookupActivity returned no results");
                }
            }

            else {
                this.onFail("STORE: LookupActivity failed");
            }

        } catch (MalformedKeyException e) {
            this.onFail("STORE: MalformedKey");
        }
    }
}

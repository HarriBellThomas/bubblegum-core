package io.hbt.bubblegum.core.kademlia.activities;

import io.hbt.bubblegum.core.auxiliary.ObjectResolutionDetails;
import io.hbt.bubblegum.core.auxiliary.ProtobufHelper;
import io.hbt.bubblegum.core.kademlia.BubblegumNode;
import io.hbt.bubblegum.core.kademlia.KademliaServerWorker;
import io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaBinaryPayload.KademliaBinaryPayload;
import io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaMessage.KademliaMessage;
import io.hbt.bubblegum.core.kademlia.router.RouterNode;


/**
 * Implementation of the RESOLVE RPC.
 */
public class ResourceRequestActivity extends NetworkActivity {

    private String uri, origin, originLocal;
    private ObjectResolutionDetails details;

    /**
     * Constructor.
     * @param localNode The owning BubblegumNode.
     * @param to The pee being asked/asking.
     * @param uri The file URI.
     */
    public ResourceRequestActivity(BubblegumNode localNode, RouterNode to, String uri) {
        super(localNode, to);
        this.uri = uri;
    }

    /**
     * Declare that this activity was created in response to another message.
     * @param responseID The exchangeIdentifier of the message.
     * @param origin The origin address.
     * @param originLocal The origin proxy/local address.
     */
    public void setResponse(String responseID, String origin, String originLocal) {
        super.setResponse(responseID);
        this.origin = origin;
        this.originLocal = originLocal;
    }

    /**
     * Run the RPC's logic.
     */
    @Override
    public void run() {
        super.run();
        if(this.uri == null || this.uri.length() == 0) {
            this.onFail();
            return;
        }

        if (this.aborted || !this.localNode.syncIfRequired(this.to)) {
            this.onFail("Aborted/Sync Failed");
            return;
        }

        if(this.isResponse && this.uri.length() > 0) {
            KademliaMessage message = this.localNode.newResourceRequest(this.to, this.exchangeID, this.origin, this.originLocal, this.uri);
            this.localNode.getServer().sendDatagram(this.localNode, this.to, message, null);
            this.onSuccess();
        }
        else {
            KademliaMessage message = ProtobufHelper.buildResourceRequest(this.localNode, this.to, this.exchangeID, this.uri);
            this.localNode.getServer().sendDatagram(this.localNode, this.to, message, (kademliaMessage -> this.gotResponse(kademliaMessage)));
            this.timeoutOnComplete();
        }

    }

    /**
     * Retrieve the ObjectResolutionDetails instance generates by this activity.
     * @return
     */
    public ObjectResolutionDetails getResolutionDetails() {
        return this.details;
    }

    /**
     * Build the ObjectResolutionDetails instance.
     * @param message The response message.
     */
    private void gotResponse(KademliaMessage message) {
        KademliaBinaryPayload payload = KademliaServerWorker.extractPayload(this.localNode, this.to, message);
        if(payload.hasResourceResponse()) {
            if(payload.getResourceResponse().getRequestKey().length() > 0) {
                this.details = new ObjectResolutionDetails(
                    payload.getResourceResponse().getServer(),
                    payload.getResourceResponse().getPort(),
                    payload.getResourceResponse().getRequestKey(),
                    payload.getResourceResponse().getEncryptionKey(),
                    payload.getResourceResponse().getMimeType()
                );
                this.onSuccess();
                return;
            }
        }

        this.onFail();
    }

} // end ResourceRequestActivity class

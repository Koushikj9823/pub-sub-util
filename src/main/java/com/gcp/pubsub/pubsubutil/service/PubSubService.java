package com.gcp.pubsub.pubsubutil.service;

import com.gcp.pubsub.pubsubutil.model.PubSubModel;
import com.gcp.pubsub.pubsubutil.model.PubSubRQ;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class PubSubService {

    @Autowired
    private PubSubOutboundStartGateway startInstanceGateway;

    @Autowired
    private PubSubOutboundStopGateway stopInstanceGateway;

    public ResponseEntity<PubSubModel> startInstance(PubSubRQ pubSubRQ){
        return buildPubSubModelResponseEntity(pubSubRQ,startInstanceGateway);
    }
    public ResponseEntity<PubSubModel> stopInstance(PubSubRQ pubSubRQ){
        return buildPubSubModelResponseEntity(pubSubRQ,stopInstanceGateway);
    }

    private ResponseEntity<PubSubModel> buildPubSubModelResponseEntity(PubSubRQ pubSubRQ,OutboundGateway messagingGateway) {
        String currentTime = String.valueOf(System.currentTimeMillis());
        PubSubModel pubSubModel = new PubSubModel(UUID.randomUUID().toString(),
                pubSubRQ.getMessage(),
                pubSubRQ.getInstanceId(),
                pubSubRQ.getProjectId(),
                currentTime,
                pubSubRQ.getOperation()
        );
        log.info("Publishing message: {}", pubSubModel);
        Gson gson = new Gson();
        messagingGateway.publish(gson.toJson(pubSubRQ));
        return ResponseEntity.ok(pubSubModel);
    }
}

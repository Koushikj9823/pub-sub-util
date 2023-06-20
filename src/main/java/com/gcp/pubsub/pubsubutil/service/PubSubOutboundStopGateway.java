package com.gcp.pubsub.pubsubutil.service;


import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "pubSubOutputStopChannel")
public interface PubSubOutboundStopGateway extends OutboundGateway{
    void publish(String message);
}

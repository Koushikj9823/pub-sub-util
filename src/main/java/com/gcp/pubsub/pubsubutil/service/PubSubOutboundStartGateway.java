package com.gcp.pubsub.pubsubutil.service;


import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "pubSubOutputStartChannel")
public interface PubSubOutboundStartGateway extends OutboundGateway{
    void publish(String message);
}

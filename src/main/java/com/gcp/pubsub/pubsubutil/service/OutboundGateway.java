package com.gcp.pubsub.pubsubutil.service;

public interface OutboundGateway {
    void publish(String message);
}

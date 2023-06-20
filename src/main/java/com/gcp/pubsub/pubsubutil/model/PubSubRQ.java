package com.gcp.pubsub.pubsubutil.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PubSubRQ {
    private String message;
    private String instanceId;
    private String projectId;
}

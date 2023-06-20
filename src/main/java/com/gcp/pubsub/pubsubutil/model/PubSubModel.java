package com.gcp.pubsub.pubsubutil.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class PubSubModel {
    private String id;
    private String message;
    private String instanceId;
    private String projectId;
    private String timeStamp;
}

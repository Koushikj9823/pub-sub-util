package com.gcp.pubsub.pubsubutil.model;

public enum Operation {
    START("start"),
    STOP("stop");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}

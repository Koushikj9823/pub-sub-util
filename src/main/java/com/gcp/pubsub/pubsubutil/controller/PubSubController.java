package com.gcp.pubsub.pubsubutil.controller;

import com.gcp.pubsub.pubsubutil.model.PubSubModel;
import com.gcp.pubsub.pubsubutil.model.PubSubRQ;
import com.gcp.pubsub.pubsubutil.service.PubSubService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PubSubController {

    @Autowired
    PubSubService service;

    @PostMapping("/start-instance")
    public ResponseEntity<PubSubModel> startInstance(@RequestBody PubSubRQ request){
        return service.startInstance(request);
    }

    @PostMapping("/stop-instance")
    public ResponseEntity<PubSubModel> stopInstance(@RequestBody PubSubRQ request){
        return service.stopInstance(request);
    }
}

package com.gcp.pubsub.pubsubutil.configuration;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;

@Configuration
@RequiredArgsConstructor
public class PubSubConfig {

    @Bean
    @ServiceActivator(inputChannel = "pubSubOutputStartChannel")
    public MessageHandler messageSenderForStartInstance(PubSubTemplate pubsubTemplate) {

        return new PubSubMessageHandler(
                pubsubTemplate, "projects/emerald-outpost-390314/topics/startInstance");
    }

    @Bean
    @ServiceActivator(inputChannel = "pubSubOutputStopChannel")
    public MessageHandler messageSenderForStopInstance(PubSubTemplate pubsubTemplate) {

        return new PubSubMessageHandler(
                pubsubTemplate, "projects/emerald-outpost-390314/topics/stopInstance");
    }
}

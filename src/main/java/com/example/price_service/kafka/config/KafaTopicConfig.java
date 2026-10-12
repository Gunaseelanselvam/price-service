package com.example.price_service.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


public class KafaTopicConfig{

    public NewTopic vehiclePriceUpdatesTopic(){
        return TopicBuilder.name("vehicle-price-updates")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
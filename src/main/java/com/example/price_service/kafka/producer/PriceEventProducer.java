package com.example.price_service.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.price_service.kafka.event.PriceUpdatedEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PriceEventProducer {

    private static final Logger log = LoggerFactory.getLogger(PriceEventProducer.class);
    public static final String TOPIC = "vehicle-price-updates";

    private final KafkaTemplate<String, PriceUpdatedEvent> kafkaTemplate;

    public PriceEventProducer(KafkaTemplate<String, PriceUpdatedEvent> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPriceUpdate(PriceUpdatedEvent event){
        log.info("prodcer publishing event for vin" , event.vin());
        kafkaTemplate.send(TOPIC, event.vin(), event);
    }

    
}

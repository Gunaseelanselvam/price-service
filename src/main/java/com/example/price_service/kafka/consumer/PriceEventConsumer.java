package com.example.price_service.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.price_service.kafka.event.PriceUpdatedEvent;

@Service
public class PriceEventConsumer {

    private static final Logger log = LoggerFactory.getLogger(PriceEventConsumer.class);

    @KafkaListener(topics = "vehicle-price-updates", groupId = "price-service-group")
    public void consumePriceUpdate(PriceUpdatedEvent event){
        log.info("consumer received vin : {}, new price: {}, update at: {}", event.vin(),
    event.newPrice(), event.updatedAt());
    }
    
}

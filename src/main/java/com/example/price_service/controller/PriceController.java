package com.example.price_service.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.price_service.dto.PriceResponse;
import com.example.price_service.service.PriceService;

@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService){
        this.priceService = priceService;
    }

    @GetMapping("/live")
    public ResponseEntity<PriceResponse> getLivePrice(
        @RequestParam(defaultValue = "USD") String base,
        @RequestParam(defaultValue = "INR") String target
        ){
            PriceResponse response =  priceService.getLiveAndPersistPrice(base,target);
            return ResponseEntity.ok(response);
        }
    
@Autowired
private com.example.price_service.kafka.producer.PriceEventProducer priceEventProducer;
@GetMapping("/trigger-test")
public String triggerKafkaTest(){
    com.example.price_service.kafka.event.PriceUpdatedEvent event = 
    new com.example.price_service.kafka.event.PriceUpdatedEvent(
        "Vin - ford - mustung -2026",
        new java.math.BigDecimal("45000.00"),
        new java.math.BigDecimal("48000.00"),
        java.time.LocalDateTime.now()
    );

    priceEventProducer.sendPriceUpdate(event);
    return "Event Published to Kafka successfully";
}

}



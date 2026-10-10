package com.example.price_service.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    
}



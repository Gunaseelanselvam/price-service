package com.example.price_service.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.price_service.dto.PriceResponse;

@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {

    @GetMapping("/live")
    public ResponseEntity<PriceResponse> getLivePrice(
        @RequestParam(defaultValue = "USD") String base,
        @RequestParam(defaultValue = "INR") String target
        ){
            PriceResponse response = new PriceResponse(
                base,
                target,
                new BigDecimal("86.50"),
                LocalDateTime.now()
            );
            return ResponseEntity.ok(response);
        }
    
}



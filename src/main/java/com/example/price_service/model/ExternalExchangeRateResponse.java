package com.example.price_service.model;

import java.math.BigDecimal;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ExternalExchangeRateResponse(
 
    String result,
    @JsonProperty("base_code") String baseCode,
    Map<String, BigDecimal> rates
) {
} 
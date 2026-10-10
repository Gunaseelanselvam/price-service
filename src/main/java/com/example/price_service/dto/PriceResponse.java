package com.example.price_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record  PriceResponse(
    String baseCurrency,
    String targetCurrency,
    BigDecimal rate,
    LocalDateTime timestamp
) {
    
}

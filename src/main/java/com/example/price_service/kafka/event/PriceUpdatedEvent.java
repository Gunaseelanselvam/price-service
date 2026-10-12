package com.example.price_service.kafka.event;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceUpdatedEvent (
    String vin, 
    BigDecimal oldPrice,
    BigDecimal newPrice,
    LocalDateTime updatedAt
){}

package com.example.price_service.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "price_records")
public class PriceRecord {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String baseCurrency;

    @Column(nullable = false, length = 10)
    private String targetCurrency;

    @Column(nullable = false, precision = 19 , scale =4)
    private BigDecimal rate;

    @Column(nullable = false)
    private LocalDateTime recordedAt;
    

    public PriceRecord(){}

    public PriceRecord(String baseCurrency , String targetCurrency, 
        BigDecimal rate, LocalDateTime recordedAt){
            this.baseCurrency = baseCurrency;
            this.targetCurrency = targetCurrency;
            this.rate = rate ;
            this.recordedAt = recordedAt;
        }
    

    public Long getId() {return id;}
    public String getBaseCurrency(){return baseCurrency;}
    public String getTargetCurrency(){return targetCurrency;}
    public BigDecimal getRate(){return rate;}
    public LocalDateTime getRecordedAt(){return recordedAt;}


}

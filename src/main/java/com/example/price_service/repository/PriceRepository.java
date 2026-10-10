package com.example.price_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.price_service.model.PriceRecord;

public interface PriceRepository extends JpaRepository <PriceRecord,  Long> {

    
}
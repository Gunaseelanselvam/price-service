package com.example.price_service.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.price_service.dto.PriceResponse;
import com.example.price_service.model.ExternalExchangeRateResponse;
import com.example.price_service.model.PriceRecord;
import com.example.price_service.repository.PriceRepository;

@Service
public class PriceService {

    private final RestClient restClient;
    private final PriceRepository priceRepository;
    
    public PriceService(RestClient restClient, PriceRepository priceRepository){
        this.restClient = restClient;
        this.priceRepository  = priceRepository;

    }


    public PriceResponse getLiveAndPersistPrice(String base, String target){
        
        ExternalExchangeRateResponse apiResponse = restClient.get()
                .uri("/{base}", base)
                .retrieve()
                .body(ExternalExchangeRateResponse.class);
    

    if(apiResponse == null || apiResponse.rates() == null || !apiResponse.rates().containsKey(target)){
       throw new IllegalArgumentException("Unsupported currency target" ); 
    }

    BigDecimal rate = apiResponse.rates().get(target);
    LocalDateTime now = LocalDateTime.now();

    PriceRecord record = new PriceRecord(base, target, rate, now);
    priceRepository.save(record);

    return new PriceResponse(base, target, rate, now );

}
    
}

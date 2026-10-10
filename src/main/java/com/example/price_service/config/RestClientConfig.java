package com.example.price_service.config;
import java.beans.BeanProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient restClient(){
        return RestClient.builder()
                .baseUrl("https://open.er-api.com/v6/latest")
                .build();
    }
    
}

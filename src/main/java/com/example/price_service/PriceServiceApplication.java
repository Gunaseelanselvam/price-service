package com.example.price_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.TimeZone;

@EnableKafka 
@SpringBootApplication
public class PriceServiceApplication {

	static {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(PriceServiceApplication.class, args);
	}

}

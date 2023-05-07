package com.ecomapi.ecomAPI;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class EcomApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcomApiApplication.class, args);
	}
}

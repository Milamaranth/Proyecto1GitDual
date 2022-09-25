package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    
	@Bean
	public Address createAddress() {
		return new Address("Palomares", 2);
	}
}

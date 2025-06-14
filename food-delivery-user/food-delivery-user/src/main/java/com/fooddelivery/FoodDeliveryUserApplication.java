package com.fooddelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"org.fooddelivery.entity"})
public class FoodDeliveryUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryUserApplication.class, args);
	}

}

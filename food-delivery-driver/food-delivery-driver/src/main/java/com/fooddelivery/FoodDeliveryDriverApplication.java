package com.fooddelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan(basePackages = "org.fooddelivery.dto")
@EntityScan(basePackages = "org.fooddelivery.entity")
public class FoodDeliveryDriverApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryDriverApplication.class, args);
	}

}

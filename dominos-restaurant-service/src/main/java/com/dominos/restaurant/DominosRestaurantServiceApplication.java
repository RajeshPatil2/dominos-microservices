package com.dominos.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DominosRestaurantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DominosRestaurantServiceApplication.class, args);
		System.out.println("Restaurant Service Started [2]..!!");
	}

}

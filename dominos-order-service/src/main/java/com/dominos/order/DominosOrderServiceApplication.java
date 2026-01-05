package com.dominos.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DominosOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DominosOrderServiceApplication.class, args);
		System.out.println("Order Service Started [1]..!!");
	}

}

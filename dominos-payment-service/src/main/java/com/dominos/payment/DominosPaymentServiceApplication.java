package com.dominos.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DominosPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DominosPaymentServiceApplication.class, args);
		System.out.println("Payment Service Started [5]..!!");
	}

}

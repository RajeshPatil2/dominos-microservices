package com.dominos.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DominosApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DominosApiGatewayApplication.class, args);
		System.out.println("Dominos API Gateway Started..!!");
	}
}

package com.dominos.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DominosServiceRegistryApplication {
	public static void main(String[] args) {
		SpringApplication.run(DominosServiceRegistryApplication.class, args);
		System.out.println("Dominos Eureka Service Started..!!");
	}
}

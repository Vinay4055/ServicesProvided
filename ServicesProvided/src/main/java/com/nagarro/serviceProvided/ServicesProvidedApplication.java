package com.nagarro.serviceProvided;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.jms.annotation.EnableJms;
@EnableDiscoveryClient
@EnableJms
@SpringBootApplication
public class ServicesProvidedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesProvidedApplication.class, args);
	}

}

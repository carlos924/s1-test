package com.example.clientapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.example.clientapi.repository")
public class ClientapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientapiApplication.class, args);
	}

}

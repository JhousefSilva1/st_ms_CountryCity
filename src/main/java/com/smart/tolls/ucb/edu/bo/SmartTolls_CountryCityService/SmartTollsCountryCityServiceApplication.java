package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class SmartTollsCountryCityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartTollsCountryCityServiceApplication.class, args);
	}

}

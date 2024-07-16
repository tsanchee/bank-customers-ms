package com.bank.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BankCustomersMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankCustomersMsApplication.class, args);
	}

}

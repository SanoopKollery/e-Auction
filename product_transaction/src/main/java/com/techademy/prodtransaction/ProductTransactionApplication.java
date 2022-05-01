package com.techademy.prodtransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.techademy.prodtransaction")
public class ProductTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductTransactionApplication.class, args);
	}

}

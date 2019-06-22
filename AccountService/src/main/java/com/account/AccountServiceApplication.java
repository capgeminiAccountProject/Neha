package com.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AccountServiceApplication.class, args);
	
	}

}

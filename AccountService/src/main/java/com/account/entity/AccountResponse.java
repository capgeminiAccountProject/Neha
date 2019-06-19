package com.account.entity;

import java.util.Optional;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AccountResponse {

	private String accountNo;	
	private Account account;
	private String requestSuccess;
	
	
}

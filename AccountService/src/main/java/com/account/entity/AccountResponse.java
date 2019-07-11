package com.account.entity;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class AccountResponse {

	private String accountNo;	
	private Account account;
	
	
}

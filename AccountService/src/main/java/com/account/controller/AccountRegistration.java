package com.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.account.entity.Account;
import com.account.entity.AccountResponse;
import com.account.repository.AccountRepository;
import com.account.service.AccountService;

@RestController
public class AccountRegistration {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AccountResponse accountResponse;
	
	@Autowired
	AccountService accountService;
	

	@PostMapping("/account/createAccount")
	public AccountResponse createAccount(@RequestBody Account account) {
		accountResponse = accountService.getResponse(account);
		return accountResponse;
		
	}
}

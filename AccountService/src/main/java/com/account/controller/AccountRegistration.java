package com.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.account.entity.Account;
import com.account.entity.AccountResponse;
import com.account.repository.AccountRepository;
import com.account.service.AccountService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class AccountRegistration {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AccountResponse accountResponse;
	
	@Autowired
	AccountService accountService;
	

	@PostMapping("/account/createAccount")
	public ResponseEntity<AccountResponse> createAccount(@RequestBody Account account) {
		AccountResponse accountResponse = accountService.getResponse(account);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(accountResponse);
		
	}
	
	@GetMapping("/account/getAccount")
	public ResponseEntity<AccountResponse> findByAccountId(@RequestParam(value="accountNo") String AccountNo) {
		
		AccountResponse accountResponse = accountService.getAccountDetails(AccountNo);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(accountResponse);
	}
	
}

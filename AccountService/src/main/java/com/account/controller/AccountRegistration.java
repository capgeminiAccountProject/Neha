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
	AccountService accountService;
	

	@PostMapping("/account/createAccount")
	public ResponseEntity<AccountResponse> createAccount(@RequestBody Account account) {
		log.info("New Account created");
		AccountResponse accountResponse = accountService.getResponse(account);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		return ResponseEntity.status(HttpStatus.CREATED).headers(header).body(accountResponse);
		
	}
	
	
	
	
	@GetMapping("/account/getAccount")
	public ResponseEntity<AccountResponse> findByAccountId(@RequestParam(value="accountNo") String AccountNo) {
	
		/*Optional<AccountResponse> accountResponse = accountService.getAccountDetails(AccountNo);
		
		if(!accountResponse.isPresent()) {
			log.error("Account No doesn't exist");
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(accountResponse.get());


		*/
		
		AccountResponse accountResponse = accountService.getAccountDetails(AccountNo);
		
		return ResponseEntity.status(HttpStatus.OK).body(accountResponse);
			
		
	}
	
	

}

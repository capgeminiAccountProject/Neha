package com.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.account.entity.Account;
import com.account.entity.AccountResponse;
import com.account.entity.UserLogin;
import com.account.exceptions.AccountNotFoundException;
import com.account.service.AccountService;
import com.account.service.UserService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class LoginController {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/login")
	public ResponseEntity<AccountResponse> getUserLogin(@RequestBody UserLogin user){
		Account account = userService.loadUserByUsername(user.getEmailId());
		AccountResponse accountResponse = accountService.getAccountDetails(account.getAccountNo());
		log.info(user.getPassword());
		log.info(account.getPassword());
		if(!bCryptPasswordEncoder.matches(user.getPassword(),account.getPassword())) {
			throw new AccountNotFoundException("Password is wrong");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(accountResponse);
	}
}

package com.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.account.entity.Account;
import com.account.entity.UserLogin;
import com.account.exceptions.AccountNotFoundException;
import com.account.service.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<Account> getUserLogin(@RequestBody UserLogin user){
		Account account = userService.loadUserByUsername(user.getEmailId());
		if(!user.getPassword().equals(account.getPassword())) {
			throw new AccountNotFoundException("Password is wrong");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(account);
	}
}

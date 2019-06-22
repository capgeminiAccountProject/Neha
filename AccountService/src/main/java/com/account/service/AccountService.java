package com.account.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.config.RandomKeyGenerator;
import com.account.entity.Account;
import com.account.entity.AccountResponse;
import com.account.repository.AccountRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AccountService {

	@Autowired
	AccountResponse accountResponse;
	
	@Autowired
	AccountRepository accountRepository;
	
	public AccountResponse getResponse(Account account) {
		String accountNo = RandomKeyGenerator.generateAccountNumber();
		account.setAccountNo(accountNo);
		accountRepository.save(account);
		accountResponse.setAccount(account);
		accountResponse.setRequestSuccess("success");
		accountResponse.setAccountNo(account.getAccountNo());
		return accountResponse;
	}
	
	public AccountResponse getAccountDetails(String accountNo) {
		try {	
				Account account = accountRepository.findByAccountNo(accountNo).orElseThrow(() -> new EntityNotFoundException());
				accountResponse.setAccount(account);
				accountResponse.setRequestSuccess("success");
				accountResponse.setAccountNo(accountNo);
			
		
		}
		catch(Exception e){
				accountResponse.setRequestSuccess("Failed");
		}
		return accountResponse;
	
	}
	
}


package com.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.config.RandomKeyGenerator;
import com.account.entity.Account;
import com.account.entity.AccountResponse;
import com.account.repository.AccountRepository;

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
	
}

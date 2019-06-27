package com.account.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.account.config.RandomKeyGenerator;
import com.account.entity.Account;
import com.account.entity.AccountResponse;
import com.account.exceptions.AccountNotFoundException;
import com.account.repository.AccountRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AccountService {

	@Autowired
	AccountResponse accountResponse;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	AccountRepository accountRepository;
	
	public AccountResponse getResponse(Account account) {
		String accountNo = RandomKeyGenerator.generateAccountNumber();
		account.setAccountNo(accountNo);
		account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
		accountRepository.save(account);
		Account accountDetails = new Account(account.getFirstName(),account.getLastName(), account.getDob(), account.getSsn(),account.getEmailId(), account.getMobileNo(), account.getHomeAddress(), account.getMailingAddress(), account.getAccountNo(), account.getAccountType(), account.getMinBalance());
		accountResponse.setAccount(accountDetails);
		accountResponse.setAccountNo(account.getAccountNo());
		return accountResponse;
	}
	
	/*public Optional<AccountResponse> getAccountDetails(String accountNo) {
		
		try {
			
		        Account account = accountRepository.findByAccountNo(accountNo).orElseThrow(() -> new AccountNotFoundException("Account Number does not exist"));
				accountResponse.setAccount(account);
				accountResponse.setAccountNo(accountNo);	
		}
		catch(EntityNotFoundException ex) {
			log.catching(ex);
		}
		
		return Optional.of(accountResponse);
	
	}
	
	*/
	
	public AccountResponse getAccountDetails(String accountNo) {
		
		try {
		Optional<Account> accountOptional = accountRepository.findByAccountNo(accountNo);
		Account account = accountOptional.orElseThrow(() -> new AccountNotFoundException("Account Number does not exist"));
		accountResponse.setAccount(account);
		accountResponse.setAccountNo(accountNo);
		}
		catch(AccountNotFoundException ex) {
			log.catching(ex);
		}
		return accountResponse;
		
	}
	
}


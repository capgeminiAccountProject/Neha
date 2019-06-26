package com.account.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.account.entity.Account;
import com.account.exceptions.AccountNotFoundException;
import com.account.repository.AccountRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account loadUserByUsername(String emailId) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		
	Optional<Account> accountOptional = accountRepository.findByEmailId(emailId);
	
	Account account = accountOptional.orElseThrow(() ->  new AccountNotFoundException("Email Id does not exist"));

	return new Account(account.getFirstName(), account.getLastName(),
			account.getDob(), account.getSsn(),account.getEmailId(), account.getPassword(), account.getMobileNo(), account.getHomeAddress(), account.getMailingAddress(), account.getAccountType(), account.getAccountNo(), account.getMinBalance());

	
	}
	
	
}

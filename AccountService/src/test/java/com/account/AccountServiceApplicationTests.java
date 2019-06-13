package com.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.account.entity.Account;
import com.account.repository.AccountRepository;

@SpringBootTest
class AccountServiceApplicationTests {

	@Autowired
	AccountRepository accountRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreateAccount() {
		Account account = new Account();
		account.setFirstName("neha");
		account.setEmailId("nehanaik9029@gmail.com");
		account.setLastName("neha");
		account.setDob("04/16/2019");
		account.setMailingAddress("illinois");
		account.setHomeAddress("new jersey");
		account.setMobileNo("6972232322");
		account.setSsn("238722323");
		account.setMinBalance(353.232);
		account.setAccountType("checking");
		accountRepository.save(account);
		
	}

}

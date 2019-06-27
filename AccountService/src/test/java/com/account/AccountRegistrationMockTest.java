package com.account;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.account.config.RandomKeyGenerator;
import com.account.controller.AccountRegistration;
import com.account.entity.Account;
import com.account.entity.AccountResponse;
import com.account.repository.AccountRepository;
import com.account.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
//@ExtendWith(MockitoExtension.class)
//@WebMvcTest(AccountRegistration.class)
class AccountRegistrationMockTest {
	
	private MockMvc mvc;
	
	@Mock
	AccountRepository accountRepository;
	
	@Mock 
	AccountService accountService;
	

	@InjectMocks
	AccountRegistration accountRegistration;
	
	
	  @BeforeEach
	  public void init(){ 
		  MockitoAnnotations.initMocks(this); 
		  mvc = MockMvcBuilders.standaloneSetup(accountRegistration).build(); 
		  
	  }
	  
	  
	//Test getAccountByAccountNumber() method in controller
	  
	@Test
	public void getAccountByAccountNumber() throws Exception {
		

		Account account = new Account("manu", "aluri", "04-04-1991", "647643434",
						"kate@gmail.com", "apple","848144134", "NJ", "Wheeling", "Saving","78546644301", 763434);
				
		Account accountDetails = new Account("manu", "aluri", "04-04-1991", "647643434",
				"kate@gmail.com","848144134", "NJ", "Wheeling", "Saving","78546644301", 763434);
		
		String accountNo = "78546644301";
		AccountResponse accountResponse = new AccountResponse(accountNo, account);

		when(accountRepository.findByAccountNo("78546644301")).thenReturn(Optional.of(accountDetails));
	//	when(accountService.getAccountDetails("78546644301")).thenReturn(Optional.of(accountResponse));

		when(accountService.getAccountDetails("78546644301")).thenReturn(accountResponse);
		mvc.perform(
				 get("/account/getAccount")
				.param("accountNo", "78546644301")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.accountNo").value("78546644301"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.account.emailId").value("kate@gmail.com"));	
						
	}
	
	
	//Test createAccount Controller method
	@Test
	public void createAccount() throws Exception{
	
        Account account = new Account();
		
		account.setFirstName("Neha");
		account.setLastName("Naik");
		account.setDob("05-18-2001");
		account.setSsn("783734544");
		account.setEmailId("neha2@gamil.com");
		account.setMobileNo("837838434");
		account.setHomeAddress("NJ");
		account.setMailingAddress("IL");
		account.setMinBalance(74364.734);
		account.setAccountType("Checking");
		
		AccountResponse accountResponse = new AccountResponse();
		
		String accountNo = RandomKeyGenerator.generateAccountNumber();
		
		account.setAccountNo(accountNo);
		accountResponse.setAccount(account);
		accountResponse.setAccountNo(account.getAccountNo());
		when(accountService.getResponse(account)).thenReturn(accountResponse);

	 
		
		mvc.perform(
				post("/account/createAccount")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(account)))
				.andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.account.emailId").value("neha2@gamil.com"));
				
	}
	
	static String asJsonString(Object object) {
	try {
		return new ObjectMapper().writeValueAsString(object);
	}
	catch(Exception e) {
		log.catching(e);
		throw new RuntimeException();
	}
	

	}
}

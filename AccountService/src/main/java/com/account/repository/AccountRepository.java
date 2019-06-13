package com.account.repository;

import org.springframework.data.repository.CrudRepository;

import com.account.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

	
}

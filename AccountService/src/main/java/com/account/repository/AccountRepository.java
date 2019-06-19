package com.account.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.account.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

	Optional<Account> findByAccountNo(String accountNo);
}

package com.account.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.account.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

	Optional<Account> findByAccountNo(String accountNo);
}

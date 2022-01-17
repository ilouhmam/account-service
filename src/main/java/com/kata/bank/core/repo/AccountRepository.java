package com.kata.bank.core.repo;

import com.kata.bank.core.domain.business.consumer.usecase.account.Account;

import java.util.Optional;

public interface AccountRepository {
    Optional<Account> save (Account account);
    Optional<Account> findById(Long id);
}

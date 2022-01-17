package com.kata.bank.core.usecase.business.consumer.account.impl;

import com.kata.bank.core.domain.business.consumer.usecase.account.Account;
import com.kata.bank.core.domain.business.consumer.usecase.account.CreateAccountRequest;
import com.kata.bank.core.domain.business.consumer.usecase.account.CreateAccountUseCase;
import com.kata.bank.core.domain.technical.exception.AccountException;
import com.kata.bank.core.repo.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * This is the Deposit use case implementation.
 *
 *
 */

@Service
@AllArgsConstructor
public class CreateAccountlUseCaseImpl implements CreateAccountUseCase {

    private final AccountRepository accountRepository;
    @Override
    public Account handle(CreateAccountRequest request) {
        Account account = new Account();
        account.setBalance(request.getBalance());
        account.setDate(request.getDate());
        account.setIban(request.getIban());
        account.setRib(request.getRib());
        return accountRepository.save(account).orElseThrow(() -> new AccountException("Account not saved"));
    }
}

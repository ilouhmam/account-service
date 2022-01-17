package com.kata.bank.core.usecase.business.consumer.deposit.impl;

import com.kata.bank.core.domain.business.consumer.usecase.deposit.DepositRequest;
import com.kata.bank.core.domain.business.consumer.usecase.deposit.DepositUseCase;
import com.kata.bank.core.domain.business.consumer.usecase.operations.ACK;
import com.kata.bank.core.domain.business.consumer.usecase.account.Account;
import com.kata.bank.core.domain.business.consumer.usecase.operations.TRANSACTION_TYPE;
import com.kata.bank.core.domain.business.consumer.usecase.operations.Transaction;
import com.kata.bank.core.domain.technical.exception.AccountException;
import com.kata.bank.core.repo.AccountRepository;
import com.kata.bank.core.repo.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * This is the Deposit use case implementation.
 *
 *
 */

@Service
@AllArgsConstructor
public class DepositUseCaseImpl implements DepositUseCase {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    @Override
    public ACK handle(DepositRequest request) {
        Account account = accountRepository.findById(request.getAccountId()).orElseThrow(() -> new AccountException("Account not exist"));;
        Transaction transaction = new Transaction();
        transaction.setAccountId(account.getId());
        transaction.setAmount(request.getAmount());
        transaction.setDate(new Date());
        transaction.setBalance(account.getBalance());
        transaction.setType(TRANSACTION_TYPE.DEPOSIT.name());
        if (request.getAmount() != null)
            account.setBalance(account.getBalance() + request.getAmount());
        accountRepository.save(account);
        transactionRepository.save(transaction);
        return ACK.OK;
    }
}

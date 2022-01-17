package com.kata.bank.core.usecase.business.consumer.withdrawal.impl;

import com.kata.bank.core.domain.business.consumer.usecase.account.Account;
import com.kata.bank.core.domain.business.consumer.usecase.operations.ACK;
import com.kata.bank.core.domain.business.consumer.usecase.operations.TRANSACTION_TYPE;
import com.kata.bank.core.domain.business.consumer.usecase.operations.Transaction;
import com.kata.bank.core.domain.business.consumer.usecase.withdrawal.WithdrawalRequest;
import com.kata.bank.core.domain.business.consumer.usecase.withdrawal.WithdrawalUseCase;
import com.kata.bank.core.domain.technical.exception.AccountException;
import com.kata.bank.core.repo.AccountRepository;
import com.kata.bank.core.repo.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * This is the Withdrawal use case implementation.
 *
 */

@Service
@AllArgsConstructor
public class WithdrawalUseCaseImpl implements WithdrawalUseCase {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    @Override
    public ACK handle(WithdrawalRequest request) {
        Account account = accountRepository.findById(request.getAccountId()).orElseThrow(() -> new AccountException("Account not exist"));
        Double balance = account.getBalance();
                Transaction transaction = new Transaction();
        transaction.setAccountId(account.getId());
        transaction.setAmount(request.getAmount());
        transaction.setDate(new Date());
        transaction.setBalance(account.getBalance());
        transaction.setType(TRANSACTION_TYPE.WITHDRAWAL.name());
        if (request.getAmount() != null)
            balance = account.getBalance() - request.getAmount();
        if (balance <= 0)
            throw new AccountException("Amount exceed balance");
        account.setBalance(balance);
        accountRepository.save(account);
        transactionRepository.save(transaction);
        return ACK.OK;
    }
}
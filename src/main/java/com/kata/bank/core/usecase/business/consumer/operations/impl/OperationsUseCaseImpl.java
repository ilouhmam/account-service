package com.kata.bank.core.usecase.business.consumer.operations.impl;

import com.kata.bank.core.domain.business.consumer.usecase.operations.OperationsUseCase;
import com.kata.bank.core.domain.business.consumer.usecase.operations.OpertaionsRequest;
import com.kata.bank.core.domain.business.consumer.usecase.operations.Transaction;
import com.kata.bank.core.domain.technical.exception.AccountException;
import com.kata.bank.core.repo.AccountRepository;
import com.kata.bank.core.repo.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This is the Withdrawal use case implementation.
 *
 */

@Service
@AllArgsConstructor
public class OperationsUseCaseImpl implements OperationsUseCase {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    @Override
    public List<Transaction> handle(OpertaionsRequest request) {
        return transactionRepository.findByAccountId(request.getAccountId()).orElseThrow(() -> new AccountException("transactions not exist"));
    }
}

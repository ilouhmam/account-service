package com.kata.bank.core.repo;

import com.kata.bank.core.domain.business.consumer.usecase.operations.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {
    Optional<Transaction> save (Transaction transaction);
    Optional<List<Transaction>> findByAccountId(Long accountId);
}

package com.kata.bank.gatways.outbound.jpa.repo;

import com.kata.bank.core.domain.business.consumer.usecase.operations.Transaction;
import com.kata.bank.core.repo.TransactionRepository;
import com.kata.bank.gatways.outbound.jpa.entity.TransactionEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {

    private final TransactionJpaRepository jpaRepository;
    @Override
    public Optional<Transaction> save(Transaction transaction) {
        return Optional.of(jpaRepository.save(TransactionEntity.fromDomain(transaction)).toDomain());
    }

    @Override
    public Optional<List<Transaction>> findByAccountId(Long accountId) {
        return Optional.of(jpaRepository.findByAccountId(accountId).get().stream().map(TransactionEntity::toDomain).collect(Collectors.toList()));
    }
}

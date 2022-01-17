package com.kata.bank.gatways.outbound.jpa.repo;

import com.kata.bank.gatways.outbound.jpa.entity.TransactionEntity;

import java.util.List;
import java.util.Optional;

public interface TransactionJpaRepository extends org.springframework.data.jpa.repository.JpaRepository<TransactionEntity, String> {
    Optional<List<TransactionEntity>> findByAccountId (Long accountId);
}

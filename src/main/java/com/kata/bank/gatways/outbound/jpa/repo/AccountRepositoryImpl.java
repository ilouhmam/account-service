package com.kata.bank.gatways.outbound.jpa.repo;

import com.kata.bank.core.domain.business.consumer.usecase.account.Account;
import com.kata.bank.core.domain.technical.exception.AccountException;
import com.kata.bank.core.repo.AccountRepository;
import com.kata.bank.gatways.outbound.jpa.entity.AccountEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountJpaRepository jpaRepository;
    @Override
    public Optional<Account> save(Account account) {
        return Optional.of(jpaRepository.save(AccountEntity.fromDomain(account)).toDomain());
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.of(jpaRepository.findById(id).orElseThrow(() -> new AccountException("Account not found")).toDomain());
    }

}

package com.kata.bank.gatways.outbound.jpa.repo;

import com.kata.bank.gatways.outbound.jpa.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, String> {
    Optional<AccountEntity> findById(Long id);
}

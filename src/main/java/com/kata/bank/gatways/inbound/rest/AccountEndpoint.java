package com.kata.bank.gatways.inbound.rest;

import com.kata.bank.core.domain.business.consumer.usecase.account.Account;
import com.kata.bank.core.domain.business.consumer.usecase.account.CreateAccountRequest;
import com.kata.bank.core.domain.business.consumer.usecase.account.CreateAccountUseCase;
import com.kata.bank.core.domain.business.consumer.usecase.deposit.DepositRequest;
import com.kata.bank.core.domain.business.consumer.usecase.deposit.DepositUseCase;
import com.kata.bank.core.domain.business.consumer.usecase.operations.ACK;
import com.kata.bank.core.domain.business.consumer.usecase.operations.OperationsUseCase;
import com.kata.bank.core.domain.business.consumer.usecase.operations.OpertaionsRequest;
import com.kata.bank.core.domain.business.consumer.usecase.operations.Transaction;
import com.kata.bank.core.domain.business.consumer.usecase.withdrawal.WithdrawalRequest;
import com.kata.bank.core.domain.business.consumer.usecase.withdrawal.WithdrawalUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountEndpoint {

    private final CreateAccountUseCase createAccountUseCase;
    private final DepositUseCase depositUseCase;
    private final WithdrawalUseCase withdrawalUseCase;
    private final OperationsUseCase operationsUseCase;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@Valid @RequestBody CreateAccountRequest request) {
        return ResponseEntity.ok(createAccountUseCase.handle(request));
    }
    @PostMapping("/deposit")
    public ResponseEntity<ACK> deposit(@Valid @RequestBody DepositRequest request) {
        return ResponseEntity.ok(depositUseCase.handle(request));
    }
    @PostMapping("/withdrawal")
    public ResponseEntity<ACK> withdrawal(@Valid @RequestBody WithdrawalRequest request) {
        return ResponseEntity.ok(withdrawalUseCase.handle(request));
    }
    @PostMapping("/operations")
    public ResponseEntity<List<Transaction>> operations(@Valid @RequestBody OpertaionsRequest request) {
        return ResponseEntity.ok(operationsUseCase.handle(request));
    }

}

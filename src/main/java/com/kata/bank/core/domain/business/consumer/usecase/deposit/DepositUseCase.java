package com.kata.bank.core.domain.business.consumer.usecase.deposit;

import com.kata.bank.core.domain.business.consumer.usecase.operations.ACK;

@FunctionalInterface
public interface DepositUseCase {

    ACK handle(DepositRequest request);

}

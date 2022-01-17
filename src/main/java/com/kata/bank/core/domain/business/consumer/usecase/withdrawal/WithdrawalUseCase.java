package com.kata.bank.core.domain.business.consumer.usecase.withdrawal;

import com.kata.bank.core.domain.business.consumer.usecase.operations.ACK;

@FunctionalInterface
public interface WithdrawalUseCase {

    ACK handle(WithdrawalRequest request);

}

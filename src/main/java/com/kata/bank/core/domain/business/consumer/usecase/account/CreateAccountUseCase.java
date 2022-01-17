package com.kata.bank.core.domain.business.consumer.usecase.account;

@FunctionalInterface
public interface CreateAccountUseCase {

    Account handle(CreateAccountRequest request);
}

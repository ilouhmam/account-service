package com.kata.bank.core.domain.business.consumer.usecase.operations;

import java.util.List;

@FunctionalInterface
public interface OperationsUseCase {

    List<Transaction> handle(OpertaionsRequest request);

}

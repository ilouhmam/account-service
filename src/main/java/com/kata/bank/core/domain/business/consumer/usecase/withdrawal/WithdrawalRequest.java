package com.kata.bank.core.domain.business.consumer.usecase.withdrawal;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WithdrawalRequest {
    @NotNull
    private Double amount;

    @NotNull
    private Long accountId;
}

package com.kata.bank.core.domain.business.consumer.usecase.deposit;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
public class DepositRequest {
    @NotNull
    private Double amount;

    @NotNull
    private Long accountId;

    private String note;

    public void validate() {
        //TODO validation code
    }
}

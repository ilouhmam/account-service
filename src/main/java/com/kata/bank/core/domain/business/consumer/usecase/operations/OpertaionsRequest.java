package com.kata.bank.core.domain.business.consumer.usecase.operations;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OpertaionsRequest {
    @NotNull
    Long accountId;

    public void validate() {
        //TODO validation code
    }
}

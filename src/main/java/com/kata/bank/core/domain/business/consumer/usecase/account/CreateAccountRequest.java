package com.kata.bank.core.domain.business.consumer.usecase.account;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CreateAccountRequest {

    String rib;
    String iban;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date date;
    @NotNull
    Double balance;

    public void validate() {
        //TODO validation code
    }
}

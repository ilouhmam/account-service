package com.kata.bank.gatways.outbound.jpa.entity;

import com.kata.bank.core.domain.business.consumer.usecase.account.Account;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account")
@Data
public class AccountEntity {

    @Id
    @GeneratedValue // (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "rib")
    private String rib;
    @Column(name = "iban")
    private String iban;
    @Column(name = "balance")
    private Double balance;

    public static AccountEntity fromDomain(Account account) {
     AccountEntity accountEntity = new AccountEntity();
     accountEntity.setBalance(account.getBalance());
     accountEntity.setDate(account.getDate());
     accountEntity.setRib(account.getRib());
     accountEntity.setIban(account.getIban());
             return accountEntity;
    }

    public Account toDomain() {
    Account account = new Account ();
    account.setId(id);
    account.setBalance(balance);
    account.setDate(date);
    account.setIban(iban);
    account.setRib(rib);
    return account;
    }
}

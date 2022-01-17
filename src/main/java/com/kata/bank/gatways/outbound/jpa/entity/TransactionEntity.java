package com.kata.bank.gatways.outbound.jpa.entity;

import com.kata.bank.core.domain.business.consumer.usecase.operations.Transaction;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
public class TransactionEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "date")
    private Date date;
    @Column(name = "type")
    private String type;
    @Column(name = "account_id")
    private Long accountId;

    public static TransactionEntity fromDomain(Transaction transaction) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAmount(transaction.getAmount());
        transactionEntity.setBalance(transaction.getBalance());
        transactionEntity.setType(transaction.getType());
        transactionEntity.setDate(transaction.getDate());
        transactionEntity.setAccountId(transaction.getAccountId());
        return transactionEntity;
    }

    public Transaction toDomain() {
        Transaction transaction = new Transaction ();
        transaction.setAmount(amount);
        transaction.setBalance(balance);
        transaction.setAccountId(accountId);
        transaction.setDate(date);
        transaction.setType(type);
        return transaction;
    }
}

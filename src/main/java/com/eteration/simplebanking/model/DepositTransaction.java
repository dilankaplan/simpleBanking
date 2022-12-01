package com.eteration.simplebanking.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

// This class is a place holder you can change the complete implementation
@Entity
@DiscriminatorValue("DepositTransaction")
public class DepositTransaction extends Transaction {
    public DepositTransaction() {
    }

    public DepositTransaction(double amount) {
        super(amount);
    }

    public DepositTransaction(Date date, double amount, Account account, String approvalCode) {
        super(date, amount, account, approvalCode);
    }
}

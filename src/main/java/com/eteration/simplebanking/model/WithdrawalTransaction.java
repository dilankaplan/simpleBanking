package com.eteration.simplebanking.model;




import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("WithdrawalTransaction")
public class WithdrawalTransaction {
    public WithdrawalTransaction() {
    }
    public WithdrawalTransaction(double amount) {
        super();
    }
    public WithdrawalTransaction(Date date, double amount, Account account, String approvalCode) {
        super();
    }

}



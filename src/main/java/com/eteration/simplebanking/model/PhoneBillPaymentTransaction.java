package com.eteration.simplebanking.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("PhoneBillPaymentTransaction")
public class PhoneBillPaymentTransaction extends Transaction{
    private String operatorName;
    private String phoneNumber;

    public PhoneBillPaymentTransaction() {
    }

    public PhoneBillPaymentTransaction(String operatorName, String phoneNumber, double amount) {
        super(amount);
        this.operatorName = operatorName;
        this.phoneNumber = phoneNumber;

    }
    public PhoneBillPaymentTransaction(Date date, double amount, Account account, String approvalCode, String operatorName, String phoneNumber) {
        super(date, amount, account, approvalCode);
        this.operatorName = operatorName;
        this.phoneNumber = phoneNumber;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

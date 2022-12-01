package com.eteration.simplebanking.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

// This class is a place holder you can change the complete implementation
@Entity
@Table(name = "transaction")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type")
public abstract class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private double amount;

    @Column(name = "type", insertable = false, updatable = false)
    private String type;

    @Column(name = "approval_code")
    private String approvalCode;

    @ManyToOne
    @JsonBackReference(value = "account")
    @JoinColumn(name = "account_id")
    private Account account;

    public Transaction() {
    }

    public Transaction(double amount) {
        this.amount = amount;
        this.date = new Date();
    }

    public Transaction(Date date, double amount, Account account, String approvalCode) {
        this.date = date;
        this.amount = amount;
        this.account = account;
        this.approvalCode = approvalCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

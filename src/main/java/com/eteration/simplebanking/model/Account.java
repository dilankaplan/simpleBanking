package com.eteration.simplebanking.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Account {
    @Entity
    @Table(name = "account")
    public class Account {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "owner")
        private String owner;

        @Column(name = "account_number")
        private String accountNumber;

        @Column(name = "balance")
        private double balance;

        @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
        private List<Transaction> transactions;

        public Account() {
        }

        public Account(String owner, String accountNumber) {
            this.owner = owner;
            this.accountNumber = accountNumber;
            if (getTransactions() == null) {
                this.transactions = new ArrayList<>();
            }
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public List<Transaction> getTransactions() {
            return transactions;
        }

        public void setTransactions(List<Transaction> transactions) {
            this.transactions = transactions;
        }

        public void post(Transaction transaction) throws InsufficientBalanceException {
            if (transaction instanceof WithdrawalTransaction) {
                withdraw(transaction.getAmount());
            } else if (transaction instanceof DepositTransaction) {
                deposit(transaction.getAmount());
            } else if (transaction instanceof PhoneBillPaymentTransaction) {
                payPhoneBill(transaction.getAmount());
            }
            getTransactions().add(transaction);
            transaction.setAccount(this);
        }

        public void deposit(double amount) {
            this.setBalance(this.getBalance() + amount);
        }

        public void withdraw(double amount) throws InsufficientBalanceException {
            if (this.getBalance() < amount) {
                throw new InsufficientBalanceException("Yetersiz Bakiye");
            }
            this.setBalance(this.getBalance() - amount);
        }

        public void payPhoneBill(double amount) throws InsufficientBalanceException {
            withdraw(amount);
        }

}

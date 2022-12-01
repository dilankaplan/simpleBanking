package com.eteration.simplebanking.services;

import com.eteration.simplebanking.controller.TransactionStatus;
import com.eteration.simplebanking.dataAccess.AccountRepository;
import com.eteration.simplebanking.dataAccess.TransactionRepository;
import com.eteration.simplebanking.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

public class AccountManager implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Account findAccount(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public TransactionStatus credit(String accountNumber, double amount) throws InsufficientBalanceException {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        TransactionStatus transactionStatus;
        if (account != null) {
            Transaction transaction = new DepositTransaction(new Date(), amount, account, UUID.randomUUID().toString());
            account.post(transaction);
            transactionRepository.save(transaction);
            accountRepository.save(account);
            transactionStatus = new TransactionStatus("OK", transaction.getApprovalCode());
        } else {
            transactionStatus = new TransactionStatus("ERROR");
        }
        return transactionStatus;
    }

    @Override
    public TransactionStatus debit(String accountNumber, double amount) throws InsufficientBalanceException {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        TransactionStatus transactionStatus;
        if (account != null) {
            Transaction transaction = new Transaction(new Date(), amount, account, UUID.randomUUID().toString());
            account.post(transaction);
            transactionRepository.save(transaction);
            accountRepository.save(account);
            transactionStatus = new TransactionStatus("OK", transaction.getApprovalCode());
        } else {
            transactionStatus = new TransactionStatus("ERROR");
        }
        return transactionStatus;
    }

    @Override
    public TransactionStatus payPhoneBill(String accountNumber, double amount, String operatorName, String phoneNumber) throws InsufficientBalanceException {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        TransactionStatus transactionStatus;
        if (account != null) {
            Transaction transaction = new PhoneBillPaymentTransaction(new Date(), amount, account, UUID.randomUUID().toString(), operatorName, phoneNumber);
            account.post(transaction);
            transactionRepository.save(transaction);
            accountRepository.save(account);
            transactionStatus = new TransactionStatus("OK", transaction.getApprovalCode());
        } else {
            transactionStatus = new TransactionStatus("ERROR");
        }
        return transactionStatus;
    }


}

package com.eteration.simplebanking.dataAccess;

import com.eteration.simplebanking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class TransactionRepository implements JpaRepository<Transaction, Integer> {
}

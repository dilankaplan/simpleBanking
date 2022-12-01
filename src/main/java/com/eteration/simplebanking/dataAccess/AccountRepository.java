package com.eteration.simplebanking.dataAccess;

import com.eteration.simplebanking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AccountRepository implements JpaRepository<Account, Integer> {
    public abstract Account findByAccountNumber(String accountNumber);
}

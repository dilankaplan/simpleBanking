package com.eteration.simplebanking.dataAccess;

import com.eteration.simplebanking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public class AccountRepository extends JpaRepository<Account, Integer> {
    public Account findByAccountNumber(String accountNumber);
}

package com.miletodev.oopbank.service;

import com.miletodev.oopbank.model.Account;
import com.miletodev.oopbank.model.User;
import com.miletodev.oopbank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AccountFactory {

    private static final Random random = new Random();

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(User user) {
        Account account = new Account();
        account.setNumber(generateAccountNumber());
        account.setAgency(1111);
        account.setBalance(BigDecimal.valueOf(0.0));
        account.setAdditionalLimit(500.0);

        user.setAccount(account);
        accountRepository.save(account); // Save the account to the database
        return account;
    }

    private long generateAccountNumber() {
        // Generate a 9-digit account number
       return ThreadLocalRandom.current().nextLong(1_000_000_000L, 10_000_000_000L);
    }

    public Account getAccount(long accountNumber) {
        Optional<Account> accountOpt = accountRepository.findByNumber(accountNumber);
        if (accountOpt.isPresent()) {
            return accountOpt.get();
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }
}
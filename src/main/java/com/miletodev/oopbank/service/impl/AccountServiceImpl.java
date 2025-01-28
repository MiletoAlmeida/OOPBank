package com.miletodev.oopbank.service.impl;

import com.miletodev.oopbank.model.Account;
import com.miletodev.oopbank.repository.AccountRepository;
import com.miletodev.oopbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void deposit(long accountNumber, BigDecimal amount) {
        Optional<Account> accountOpt = accountRepository.findByNumber(accountNumber);
        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            account.setBalance(account.getBalance().add(amount));
            accountRepository.save(account);
        }
    }

    @Override
    public void withdraw(long accountNumber, BigDecimal amount) {
        Optional<Account> accountOpt = accountRepository.findByNumber(accountNumber);
        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            account.setBalance(account.getBalance().subtract(amount));
            accountRepository.save(account);
        }
    }

    @Override
    public void transfer(long accountNumberFrom, long accountNumberTo, BigDecimal amount) {
        Optional<Account> accountOptFrom = accountRepository.findByNumber(accountNumberFrom);
        Optional<Account> accountOptTo = accountRepository.findByNumber(accountNumberTo);
        if (accountOptFrom.isPresent() && accountOptTo.isPresent()) {
            Account accountFrom = accountOptFrom.get();
            Account accountTo = accountOptTo.get();
            accountFrom.setBalance(accountFrom.getBalance().subtract(amount));
            accountTo.setBalance(accountTo.getBalance().add(amount));
            accountRepository.save(accountFrom);
            accountRepository.save(accountTo);
        }
    }

    @Override
    public BigDecimal checkBalance(long accountNumber) {
        Optional<Account> accountOpt = accountRepository.findByNumber(accountNumber);
        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            return account.getBalance();
        }
        return BigDecimal.ZERO;
    }
}
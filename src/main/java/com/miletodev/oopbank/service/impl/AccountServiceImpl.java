package com.miletodev.oopbank.service.impl;

import com.miletodev.oopbank.exception.AccountNotFoundException;
import com.miletodev.oopbank.model.Account;
import com.miletodev.oopbank.model.User;
import com.miletodev.oopbank.repository.AccountRepository;
import com.miletodev.oopbank.repository.UserRepository;
import com.miletodev.oopbank.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;

    private final UserRepository userRepository;

    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    private Account getAccount(long accountNumber) {
        logger.info("Fetching account with number {}", accountNumber);
        Optional<Account> accountOpt = accountRepository.findByNumber(accountNumber);
        if (accountOpt.isPresent()) {
            return accountOpt.get();
        } else {
            logger.error("Account with number {} not found", accountNumber);
            throw new AccountNotFoundException("Account not found");
        }
    }

    @Override
    public void deposit(long userId, BigDecimal amount) {
        logger.info("Depositing {} into account {}", amount, userId);
        Account account = getAccount(userId);
        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);
        logger.info("Deposit successful. New balance: {}", account.getBalance());
    }

    @Override
    public void withdraw(long userId, BigDecimal amount) {
        logger.info("Withdrawing {} from account {}", amount, userId);
        Account account = getAccount(userId);
        account.setBalance(account.getBalance().subtract(amount));
        accountRepository.save(account);
        logger.info("Withdrawal successful. New balance: {}", account.getBalance());
    }

    @Override
    public void transfer(long userIdFrom, long userIdTo, BigDecimal amount) {
        logger.info("Transferring {} from account {} to account {}", amount, userIdFrom, userIdTo);
        Account accountFrom = getAccount(userIdFrom);
        Account accountTo = getAccount(userIdTo);

        if (accountFrom.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        accountFrom.setBalance(accountFrom.getBalance().subtract(amount));
        accountTo.setBalance(accountTo.getBalance().add(amount));
        accountRepository.save(accountFrom);
        accountRepository.save(accountTo);
        logger.info("Transfer successful. New balance of account {}: {}", userIdFrom, accountFrom.getBalance());
        logger.info("New balance of account {}: {}", userIdTo, accountTo.getBalance());
    }

    @Override
    public BigDecimal checkBalance(long userId) {
        logger.info("Checking balance for user with ID {}", userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Account account = user.getAccount();
        if (account == null) {
            throw new IllegalArgumentException("Account not found for user");
        }
        logger.info("Balance for user with ID {}: {}", userId, account.getBalance());
        return account.getBalance();
    }
}
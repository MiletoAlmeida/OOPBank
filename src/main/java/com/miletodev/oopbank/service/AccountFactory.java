package com.miletodev.oopbank.service;

import com.miletodev.oopbank.model.Account;
import com.miletodev.oopbank.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class AccountFactory {

    private static final Random random = new Random();

    public Account createAccount(User user) {
        Account account = new Account();
        account.setNumber(generateAccountNumber());
        account.setAgency(1111);
        account.setBalance(BigDecimal.valueOf(0.0));
        account.setAdditionalLimit(500.0);

        user.setAccount(account);
        return account;
    }

    private long generateAccountNumber() {
        // Gerar número da conta com 9 dígitos
        return 100000000L + random.nextLong() % 900000000L;
    }

}
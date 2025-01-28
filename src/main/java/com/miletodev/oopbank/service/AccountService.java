package com.miletodev.oopbank.service;

import java.math.BigDecimal;

public interface AccountService {
    void deposit(long accountNumber, BigDecimal amount);
    void withdraw(long accountNumber, BigDecimal amount);
    void transfer(long accountNumberFrom, long accountNumberTo, BigDecimal amount);
    BigDecimal checkBalance(long accountNumber);
}

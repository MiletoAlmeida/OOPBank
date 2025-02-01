package com.miletodev.oopbank.controller;

import com.miletodev.oopbank.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * REST controller for managing account-related operations such as deposit, withdrawal, transfer, and balance check.
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    /**
     * Endpoint for depositing an amount into an account.
     *
     * @param accountId The ID of the account.
     * @param amount The amount to deposit.
     * @return ResponseEntity with a success message.
     */
    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestParam long accountId, @RequestParam BigDecimal amount) {
        accountServiceImpl.deposit(accountId, amount);
        return ResponseEntity.ok("Deposit successful!");
    }

    /**
     * Endpoint for withdrawing an amount from an account.
     *
     * @param accountId The ID of the account.
     * @param amount The amount to withdraw.
     * @return ResponseEntity with a success message.
     */
    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam long accountId, @RequestParam BigDecimal amount) {
        accountServiceImpl.withdraw(accountId, amount);
        return ResponseEntity.ok("Withdrawal successful!");
    }

    /**
     * Endpoint for transferring an amount from one account to another.
     *
     * @param fromAccountId The ID of the source account.
     * @param toAccountId The ID of the destination account.
     * @param amount The amount to transfer.
     * @return ResponseEntity with a success message.
     */
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestParam long fromAccountId, @RequestParam long toAccountId, @RequestParam BigDecimal amount) {
        accountServiceImpl.transfer(fromAccountId, toAccountId, amount);
        return ResponseEntity.ok("Transfer successful!");
    }

    /**
     * Endpoint for checking the balance of an account.
     *
     * @param accountId The ID of the account.
     * @return ResponseEntity with the account balance.
     */
    @GetMapping("/balance")
    public ResponseEntity<BigDecimal> checkBalance(@RequestParam long accountId) {
        BigDecimal balance = accountServiceImpl.checkBalance(accountId);
        return ResponseEntity.ok(balance);
    }
}
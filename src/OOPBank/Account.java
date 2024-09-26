package OOPBank;

import java.util.Random;

public class Account {
    private int accountNumber;
    private int agencyNumber;
    private double balance;

    public Account() {
        this.accountNumber = generateRandomNumber(100000, 999999); // Random 6-digit account number
        this.agencyNumber = generateRandomNumber(1000, 9999); // Random 4-digit agency number
        this.balance = 0.0;
    }

    private int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getAgencyNumber() {
        return agencyNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}
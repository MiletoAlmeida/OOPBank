package Registration;

import OOPBank.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class User {
    private long id;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String address;
    private Date dob;
    private double income;
    private String occupation;
    private int agency;
    private int accountNumber;
    private double balance;
    private long creditCardNumber;
    private boolean isBlocked;
    private double creditLimit;

    public User(long id, String password, String name, String surname, String email, String phoneNumber, String address, Date dobInput, double income, String occupation, int agency, int accountNumber) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dob = dobInput;
        this.income = income;
        this.occupation = occupation;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.creditCardNumber = (long) (Math.random() * 1000000000);
        this.isBlocked = false;
        this.creditLimit = (income / 30) * 100;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Date getDob() {
        return dob;
    }

    public double getIncome() {
        return income;
    }

    public String getOccupation() {
        return occupation;
    }

    public int getAgency() {
        return agency;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void deposit(double depositAmount) {
        balance += depositAmount;
        updateBalanceInDatabase();
        System.out.println("Deposit successful. Your new balance is: $" + balance);
    }

    public void withdraw(double withdrawAmount) {
        if (withdrawAmount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= withdrawAmount;
            updateBalanceInDatabase();
            System.out.println("Withdrawal successful. Your new balance is: $" + balance);
        }
    }

    public void transfer(int transferAccountNumber, double transferAmount) {
        if (transferAmount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= transferAmount;
            System.out.println("Transfer successful. Your new balance is: $" + balance);
        }
    }

    public void updateBalanceInDatabase() {
        String sql = "UPDATE users SET balance = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, balance);
            pstmt.setLong(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update balance in the database.");
        }
    }

    public void updateCreditLimitInDatabase() {
        String sql = "UPDATE users SET credit_limit = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, creditLimit);
            pstmt.setLong(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update credit limit in the database.");
        }
    }

    static void saveAgencyToDatabase(int agency) {
        String sql = "INSERT INTO users (agency) VALUES (?) ON CONFLICT (agency) DO NOTHING"; // Evita duplicação
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, agency);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to save agency in the database.");
        }
    }

    static void saveAccountNumberToDatabase(int accountNumber) {
        String sql = "INSERT INTO users (account_number) VALUES (?) ON CONFLICT (account_number) DO NOTHING"; // Evita duplicação
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, accountNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to save account number in the database.");
        }
    }

    }

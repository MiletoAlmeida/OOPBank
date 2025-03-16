package com.miletodev.oopbank;

import com.miletodev.oopbank.model.User;
import com.miletodev.oopbank.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.miletodev.oopbank.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Main class for the OOPBank application.
 * OOPBank is a simple banking application that allows users to register and login.
 */
@SpringBootApplication
public class OOPBank {
    private final UserServiceImpl userService;
    private final AccountServiceImpl accountServiceImpl;

    /**
     * Constructor for OOPBank.
     *
     * @param userService the user service implementation
     */
    public OOPBank(UserServiceImpl userService, AccountServiceImpl accountServiceImpl) {
        this.userService = userService;
        this.accountServiceImpl = accountServiceImpl;
    }

    /**
     * Main method to start the Spring Boot application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Initialize the Spring context
        ApplicationContext context = SpringApplication.run(OOPBank.class, args);

        // Retrieve the OOPBank bean from the Spring context
        OOPBank app = context.getBean(OOPBank.class);
        app.startConsoleMenu();
    }

    /**
     * Starts the console menu for user interaction.
     */
    private void startConsoleMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to OOPBank!");
        while (true) { // Loop to keep the menu active until the user chooses to exit
            System.out.println("Choose an option: ");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int option = 0;

            try {
                option = input.nextInt();
                input.nextLine(); // Consume the newline
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // Clear invalid input
                continue;
            }

            switch (option) {
                case 1:
                    registerUser(input);
                    break;
                case 2:
                    loginUser(input);
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    input.close();
                    exit(0);
                    return; // End the program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Registers a new user by collecting user details from the console input.
     *
     * @param input the Scanner object for reading console input
     */
    private void registerUser(Scanner input) {
        System.out.println("Let's start to create your account.");
        System.out.println("Please provide the following details:");

        System.out.print("ID: ");
        long id = input.nextLong();
        input.nextLine(); // Consume the newline

        System.out.print("First Name: ");
        String firstName = input.nextLine();

        System.out.print("Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Email: ");
        String email = input.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = input.nextLine();

        System.out.print("Address: ");
        String address = input.nextLine();

        System.out.print("Birthday (yyyy-MM-dd): ");
        LocalDate birthday;
        while (true) {
            try {
                String birthdayInput = input.nextLine();
                birthday = LocalDate.parse(birthdayInput);
                break;
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        }

        System.out.print("Income: ");
        double income = input.nextDouble();
        input.nextLine(); // Consume the newline

        System.out.print("Occupation: ");
        String occupation = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        // Create the User object
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setSurname(lastName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        user.setBirthday(birthday);
        user.setIncome(income);
        user.setOccupation(occupation);
        user.setPassword(password);
        userService.save(user);
        System.out.println("User registered successfully!");
    }

    /**
     * Logs in an existing user by verifying their ID and password.
     *
     * @param input the Scanner object for reading console input
     */
    private void loginUser(Scanner input) {
        System.out.print("Enter your ID: ");
        long id = input.nextLong();
        input.nextLine(); // Consume the newline

        System.out.print("Enter your password: ");
        String password = input.nextLine();

        // Authenticate using UserService
        boolean isAuthenticated = userService.authenticate(id, password);

        if (isAuthenticated) {
            System.out.println("Login successful! Welcome!");
            accountMenu(input, id, password);
        } else {
            if (userService.exists(id)) {
                System.out.println("Invalid password. Please try again.");
            } else {
                System.out.println("User not found. Please register first.");
            }
        }
    }

    public void accountMenu(Scanner input, long accountId, String password) {
        while (true) {
            System.out.println("Account Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Check Balance");
            System.out.println("5. Logout");

            int option = input.nextInt();
            input.nextLine(); // Consume the newline

            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    BigDecimal depositAmount = input.nextBigDecimal();
                    input.nextLine(); // Consume the newline
                    accountServiceImpl.deposit(accountId, depositAmount);
                    System.out.println("Deposit successful! Your balance is now: " + accountServiceImpl.checkBalance(accountId));
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    BigDecimal withdrawAmount = input.nextBigDecimal();
                    input.nextLine(); // Consume the newline
                    accountServiceImpl.withdraw(accountId, withdrawAmount);
                    System.out.println("Withdrawal successful! Your balance is now: " + accountServiceImpl.checkBalance(accountId));
                    break;
                case 3:
                    System.out.print("Enter destination account ID: ");
                    long toAccountId = input.nextLong();
                    input.nextLine(); // Consume the newline
                    System.out.print("Enter amount to transfer: ");
                    BigDecimal transferAmount = input.nextBigDecimal();
                    input.nextLine(); // Consume the newline
                    accountServiceImpl.transfer(accountId, toAccountId, transferAmount);
                    System.out.println("Transfer successful! Your balance is now: " + accountServiceImpl.checkBalance(accountId));
                    break;
                case 4:
                    BigDecimal balance = accountServiceImpl.checkBalance(accountId);
                    System.out.println("Your balance is: " + balance);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return; // Exit the account menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
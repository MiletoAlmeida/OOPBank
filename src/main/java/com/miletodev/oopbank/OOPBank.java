package com.miletodev.oopbank;

import com.miletodev.oopbank.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.miletodev.oopbank.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    /**
     * Constructor for OOPBank.
     *
     * @param userService the user service implementation
     */
    public OOPBank(UserServiceImpl userService) {
        this.userService = userService;
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
        Date birthday;
        while (true) {
            try {
                String birthdayInput = input.nextLine();
                birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayInput);
                break;
            } catch (ParseException e) {
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
        } else {
            if (userService.exists(id)) {
                System.out.println("Invalid password. Please try again.");
            } else {
                System.out.println("User not found. Please register first.");
            }
        }
    }
}
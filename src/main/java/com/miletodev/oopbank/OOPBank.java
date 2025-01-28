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

@SpringBootApplication
public class OOPBank {

    private final UserServiceImpl userService;

    public OOPBank(UserServiceImpl userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        // Inicialização do contexto do Spring
        ApplicationContext context = SpringApplication.run(OOPBank.class, args);

        // Recupera as instâncias dos beans do Spring
        OOPBank app = context.getBean(OOPBank.class);
        app.startConsoleMenu();
    }

    private void startConsoleMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to OOPBank!");
        while (true) { // Loop para manter o menu ativo até o usuário escolher sair
            System.out.println("Choose an option: ");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int option = 0;

            try {
                option = input.nextInt();
                input.nextLine(); // Consumir a quebra de linha
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // Limpar entrada inválida
                continue;
            }

            switch (option) {
                case 1:
                    registerUser(input);
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    input.close();
                    return; // Encerra o programa
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private void registerUser(Scanner input) {
            System.out.println("Let's start to create your account.");
            System.out.println("Please provide the following details:");

            System.out.print("ID: ");
            long id = input.nextLong();
            input.nextLine(); // Consumir quebra de linha

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
            input.nextLine(); // Consumir quebra de linha

            System.out.print("Occupation: ");
            String occupation = input.nextLine();

            System.out.print("Password: ");
            String password = input.nextLine();

            // Criar o objeto User
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

    private void loginUser (Scanner input) {
        System.out.print("Enter your ID: ");
        long id = input.nextLong();
        input.nextLine(); // Consumir quebra de linha

        System.out.print("Enter your password: ");
        String password = input.nextLine();

        // Autenticar usando LoginService
        boolean isAuthenticated = userService.authenticate(id, password);

        if (isAuthenticated) {
            System.out.println("Login successful! Welcome!");
        } else {
            System.out.println("Invalid ID or password. Please try again.");
        }
    }
}
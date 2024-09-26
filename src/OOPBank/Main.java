package OOPBank;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to OOPank!");
        System.out.print("Please, enter your full name: ");
        String fullName = scanner.nextLine();

        System.out.println("Please, enter your nickname: ");
        String nickname = scanner.nextLine();

        System.out.println("Please, enter your address: ");
        String address = scanner.nextLine();

        System.out.println("Please, enter your birthday in MM/DD/YYYY format: ");
        String birthday = scanner.nextLine();

        System.out.println("Please, enter your email: ");
        String email = scanner.nextLine();

        Customer customer = new Customer(fullName, nickname, address, birthday, email);
        bank.addCustomer(customer);

        Account account = new Account();
        customer.addAccount(account);

        System.out.println("Your Agency Number:  " + account.getAgencyNumber());
        System.out.println("Your Account Number: " + account.getAccountNumber());
        System.out.println(("Your Balance:         " + account.getBalance()));
        System.out.println("Thank you for being our client!");

        scanner.close();
    }
}
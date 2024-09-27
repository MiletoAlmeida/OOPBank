package OOPBank;

import Registration.In;
import Registration.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DigitalBank {
    public static Map<Long, User> clients = new HashMap<Long, User>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Welcome to OOPank, your friendly digital bank!\n1. Register\n2. Login\n3. Exit\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consuming the newline

            switch (choice) {
                case 1:
                    In.SignUp();
                    break;
                case 2:
                    In.SignIn();
                    break;
                case 3:
                    System.out.println("Thank you for using OOPBank!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
        }
    }
}

    public static Scanner getScanner() {
        return scanner;
    }
}

// The DigitalBank class is the main
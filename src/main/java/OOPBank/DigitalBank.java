package OOPBank;

import Registration.In;
import Registration.User;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class DigitalBank {
    public static Map<Long, User> clients = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static String readInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

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
                    User user = In.SignIn();
                    if (user != null) {
                        Account account = new Account(user);
                        account.showAccountDetails();
                    } else {
                        System.out.println("Invalid credentials. Please try again.");
                    }
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

    public static class Account {
        private User user;

        public Account(User user) {
            this.user = user;
        }

        public void showAccountDetails() {
            displayAccountInfo();
            int choice = getAccountActionChoice();
            handleAccountAction(choice);
        }

        private void displayAccountInfo() {
            System.out.println("Hello, " + user.getName() + ", here's your account details: ");
            System.out.println("Agency: " + user.getAgency() + "\nAccount number: " + user.getAccountNumber() + "\nBalance: $" + user.getBalance());
        }

        private int getAccountActionChoice() {
            System.out.println("1. Deposit   2. Withdraw   3. Credit   4. Transfer   5. Investments   6. Exit");
            return scanner.nextInt();
        }

        private void handleAccountAction(int choice) {
            switch (choice) {
                case 1:
                    performDeposit();
                    break;
                case 2:
                    performWithdraw();
                    break;
                case 3:
                    handleCreditRequest();
                    break;
                case 4:
                    performTransfer();
                    break;
                case 5:
                    handleInvestments();
                    break;
                case 6:
                    exitBank();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            showAccountDetails();
        }

        private double performDeposit() {
            System.out.println("Enter the deposit amount: ");
            double depositAmount = scanner.nextDouble();
            scanner.nextLine();

            if (depositAmount > 0) {
                user.deposit(depositAmount);
                user.updateBalanceInDatabase();
                return user.getBalance();
            } else {
                System.out.println("Invalid deposit amount. Please try again.");
            }
            return depositAmount;
        }

        private void performWithdraw() {
            System.out.println("Enter the withdrawal amount: ");
            double withdrawalAmount = scanner.nextDouble();
            scanner.nextLine();

            if (withdrawalAmount > 0 && withdrawalAmount <= user.getBalance()) {
                user.withdraw(withdrawalAmount);
                user.updateBalanceInDatabase();
            } else if (withdrawalAmount >= user.getCreditLimit()){
                System.out.println("Unfortunately your balance is: $" + user.getBalance() + ", \nbut your credit limit is: $" + user.getCreditLimit() +".\nWould you like to withdraw from your credit limit?\n1. Yes\n2. No");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) {
                    user.withdraw(withdrawalAmount);
                    user.updateCreditLimitInDatabase();
                    System.out.println("Your new credit limit is: $" + user.getCreditLimit());
                } else {
                    System.out.println("Invalid withdrawal amount. Please try again.");
                }
            }
        }

        private void handleCreditRequest() {
            System.out.println("Your credit limit is: $" + user.getCreditLimit());
            showAccountDetails();
        }

        private void performTransfer() {
            System.out.print("Enter the account number you want to transfer to: ");
            int transferAccountNumber = scanner.nextInt();
            scanner.nextLine();

            User recipientUser = DigitalBank.clients.values().stream()
                    .filter(user -> user.getAccountNumber() == transferAccountNumber)
                    .findFirst()
                    .orElse(null);

            if (recipientUser == null) {
                System.out.println("Invalid account number. Please try again.");
                return;
            }

            System.out.print("Enter the transfer amount: ");
            double transferAmount = scanner.nextDouble();
            scanner.nextLine();

            if (transferAmount > 0 && transferAmount <= user.getBalance()) {
                user.transfer(transferAccountNumber, transferAmount);
                recipientUser.deposit(transferAmount);
                System.out.println("Transfer successful! Your new balance is: $" + user.getBalance());
            } else {
                System.out.println("Invalid transfer amount. Please try again.");
            }
        }

        private void handleInvestments() {
            System.out.println("Investments coming soon!");
            showAccountDetails();
        }

        private void exitBank() {
            System.out.println("Thank you for using OOPBank!");
            System.exit(0);
        }
    }
}

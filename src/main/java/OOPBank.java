import model.User;
import repository.UserRepository;
import service.AccountFactory;
import service.UserService;
import service.impl.UserServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OOPBank {
    public static void main(String[] args) {
        UserRepository userRepository = new userRepository();
        AccountFactory accountFactory = new AccountFactory();
        UserService userService = new UserServiceImpl(userRepository, accountFactory);

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
                    UserRegister(input, userService);
                    break;
                case 2:
                    UserLogin(input, userService);
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

    public static void UserRegister(Scanner input, UserService userService) {
        System.out.println("Let's start to create your account.");
        User user = new User();

        System.out.println("ID: ");
        while (!input.hasNextLong()) {
            System.out.println("Invalid ID. Please enter a numeric value.");
            input.next(); // Consumir entrada inválida
        }
        user.setId(input.nextLong());
        input.nextLine(); // Consumir quebra de linha

        System.out.println("First name: ");
        user.setFirstName(input.nextLine());

        System.out.println("Surname: ");
        user.setSurname(input.nextLine());

        System.out.println("Email: ");
        user.setEmail(input.nextLine());

        System.out.println("Phone number: ");
        user.setPhoneNumber(input.nextLine());

        System.out.println("Address: ");
        user.setAddress(input.nextLine());

        Date birthday = null;
        while (birthday == null) {
            System.out.println("Birthday (yyyy-MM-dd): ");
            String birthdayInput = input.nextLine();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                birthday = dateFormat.parse(birthdayInput);
                user.setBirthday(birthday);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        System.out.println("Income: ");
        while (!input.hasNextDouble()) {
            System.out.println("Invalid income. Please enter a numeric value.");
            input.next(); // Consumir entrada inválida
        }
        user.setIncome(input.nextDouble());
        input.nextLine(); // Consumir quebra de linha

        System.out.println("Occupation: ");
        user.setOccupation(input.nextLine());

        System.out.println("User created successfully! Now, please set a password: ");
        user.setPassword(input.nextLine());

        // Salvar o usuário no repositório
        userService.save(user);
        System.out.println("User registered successfully!");

    }

    public static void UserLogin(Scanner input, UserService userService) {
        System.out.println("Enter your ID: ");
        long id;

        // Validação para garantir que o ID é um número
        while (!input.hasNextLong()) {
            System.out.println("Invalid ID. Please enter a numeric value.");
            input.next(); // Consumir entrada inválida
        }
        id = input.nextLong();
        input.nextLine(); // Consumir quebra de linha

        // Buscar usuário pelo ID
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User not found. Please register first.");
            return;
        }

        System.out.println("Enter your password: ");
        String password = input.nextLine();

        if (user.checkPassword(password)) {
            System.out.println("Login successful! Welcome, " + user.getFirstName() + "!");
        } else {
            System.out.println("Invalid password. Please try again.");
        }
    }
}

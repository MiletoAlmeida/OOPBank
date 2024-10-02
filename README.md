# OOPBank

**OOPBank** is a digital banking project developed in Java using Object-Oriented Programming (OOP) concepts. The project aims to create a basic banking account management system with functionalities such as account creation, login, deposits, withdrawals, and transfers.

## Table of Contents

- [Installation](#installation)
  - [For Developers](#for-developers)
  - [For End Users (Run the Application)](#for-end-users-run-the-application)
- [Usage](#usage)
  - [Database](#database)
  - [Execution](#execution)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Contribution](#contribution)
- [License](#license)
- [Authors](#authors)

## Installation

### For Developers

To run this project locally, follow the steps below:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/miletodev/OOPBank.git
   ```

2. **Open the project** in your preferred IDE (e.g., IntelliJ IDEA).

3. **Ensure that the necessary dependencies are installed** (Java JDK 17, PostgreSQL, and Maven).

4. **Build the project** using Maven:
   Navigate to the project directory and run:
   ```bash
   mvn clean install
   ```

5. **Configure the PostgreSQL database** as described in the usage section.

### For End Users (Run the Application)

If you just want to run the application, follow the steps below:

1. **Download the JRE (Java Runtime Environment):**

   If you do not have Java installed, download and install the latest JRE (Java Runtime Environment). You can download the JRE directly from the official Oracle website.

2. **Install Git:**

   If you do not have Git installed, download and install Git from the official website. Follow the installation instructions based on your operating system.

3. **Clone the Repository:**

   Open the terminal (Command Prompt on Windows, Terminal on macOS or Linux).

   Navigate to the directory where you want to download the project.

   Execute the following command to clone the repository:
   ```bash
   git clone https://github.com/miletodev/OOPBank.git
   ```
   This will create a folder named `OOPBank` with all the project files.

4. **Obtain the Project Executable:**

   In the cloned repository, you should have a file named `OOPBank.jar`. Ensure that it is in the root directory of the project.

5. **Run the Application:**

   In the terminal, navigate to the OOPBank project folder:
   ```bash
   cd OOPBank
   ```

   To run the application, use the following command:
   ```bash
   java -jar OOPBank.jar
   ```
   The system should start, and you will see a command-line interface that allows you to manage your banking operations.

6. **Configure the PostgreSQL Database:**

   The project uses a PostgreSQL database. To set it up:

   - Install PostgreSQL: [Download PostgreSQL](https://www.postgresql.org/download/)

   After installation, open `psql` (the PostgreSQL client) and run the following commands to create the database and the table:
   ```sql
   CREATE DATABASE digital_bank;
   \c digital_bank
   CREATE TABLE users (
       id SERIAL PRIMARY KEY,
       password VARCHAR(255),
       name VARCHAR(255),
       surname VARCHAR(255),
       email VARCHAR(255),
       phone_number VARCHAR(20),
       address VARCHAR(255),
       dob DATE,
       income NUMERIC(15, 2),
       occupation VARCHAR(255),
       agency VARCHAR(20),
       account_number VARCHAR(20),
       balance NUMERIC(15, 2),
       credit_limit NUMERIC(15, 2)
   );
   ```

7. **Execute the Application:**

   After configuring the database and downloading the `.jar` file of the application, you can run the project with the following command in the terminal:
   ```bash
   java -jar OOPBank.jar
   ```
   The system should start, presenting a command-line interface for you to create accounts, log in, and manage your banking operations.

## Usage

### Database

The project uses a PostgreSQL database to store user information and their accounts. Make sure you have PostgreSQL installed and create the database as per the included `schema.sql` file in the project.

### Execution

After configuring the database, run the project directly in your IDE. The system will present a command-line interface (CLI) that allows the user to perform the following actions:

- Create a new bank account.
- Log in with existing credentials.
- Check balance, make withdrawals, deposits, and transfers.

## Features

- Account creation with automatic generation of agency and account numbers.
- Secure login using ID and password.
- Real-time balance inquiries.
- Deposits, withdrawals, and transfers between accounts.
- Data persistence using PostgreSQL.

## Technologies Used

- Java
- PostgreSQL
- IntelliJ IDEA
- Maven

## Contribution

Contributions are always welcome! To contribute:

1. Fork the project.
2. Create a branch with your new feature:
   ```bash
   git checkout -b feature/new-feature
   ```
3. Make your changes and commit:
   ```bash
   git commit -m "Adds new feature"
   ```
4. Push the changes:
   ```bash
   git push origin feature/new-feature
   ```
5. Open a Pull Request.

## License

This project is licensed under the MIT License.

## Authors

Mileto Almeida - Developer - [GitHub](https://github.com/miletodev)
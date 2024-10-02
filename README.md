# OOPBank [ENG]

**OOPBank** is a digital banking project developed in Java using Object-Oriented Programming (OOP) concepts. The project aims to create a basic banking account management system with functionalities such as account creation, login, deposits, withdrawals, and transfers.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Contribution](#contribution)
- [License](#license)
- [Authors](#authors)

## Installation

### For Developers

To run this project locally, follow the steps below:

1.1. Clone the repository:
   ```bash
   git clone https://github.com/miletodev/OOPBank.git

1.2. Open the project in your preferred IDE (e.g., IntelliJ IDEA).

1.3. Ensure that the necessary dependencies are installed (Java JDK 17 and PostgreSQL).

1.4. Configure the PostgreSQL database as described in the usage section.

For End Users (Run the Application)

If you just want to run the application, follow the steps below:

1.1. Download the JRE (Java Runtime Environment):

If you do not have Java installed, download and install the latest JRE (Java Runtime Environment). You can download the JRE directly from the official Oracle website.

1.2. Install Git:

If you do not have Git installed, download and install Git from the official website.

Follow the installation instructions based on your operating system.

1.3. Clone the Repository:

Open the terminal (Command Prompt on Windows, Terminal on macOS or Linux).

Navigate to the directory where you want to download the project.

Execute the following command to clone the repository:

git clone https://github.com/miletodev/OOPBank.git

This will create a folder named OOPBank with all the project files.

2. Obtain the Project Executable:



In the cloned repository, you should have a file named OOPBank.jar. Ensure that it is in the root directory of the project.

3. Run the Application:



In the terminal, navigate to the OOPBank project folder:

cd OOPBank

To run the application, use the following command:

java -jar OOPBank.jar

The system should start, and you will see a command-line interface that allows you to manage your banking operations.

4. Configure the PostgreSQL Database:



The project uses a PostgreSQL database. To set it up:

Install PostgreSQL: Download PostgreSQL

After installation, open psql (the PostgreSQL client) and run the following commands to create the database and the table:

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

5. Execute the Application:



After configuring the database and downloading the .jar file of the application, you can run the project with the following command in the terminal:

java -jar OOPBank.jar

The system should start, presenting a command-line interface for you to create accounts, log in, and manage your banking operations.

Usage

Database

The project uses a PostgreSQL database to store user information and their accounts. Make sure you have PostgreSQL installed and create the database as per the included schema.sql file in the project.

Execution

After configuring the database, run the project directly in your IDE. The system will present a command-line interface (CLI) that allows the user to perform the following actions:

Create a new bank account.

Log in with existing credentials.

Check balance, make withdrawals, deposits, and transfers.


Features

Account creation with automatic generation of agency and account numbers.

Secure login using ID and password.

Real-time balance inquiries.

Deposits, withdrawals, and transfers between accounts.

Data persistence using PostgreSQL.


Technologies Used

Java

PostgreSQL

IntelliJ IDEA


Contribution

Contributions are always welcome! To contribute:

1. Fork the project.


2. Create a branch with your new feature:

git checkout -b feature/new-feature


3. Make your changes and commit:

git commit -m "Adds new feature"


4. Push the changes:

git push origin feature/new-feature


5. Open a Pull Request.



License

This project is licensed under the MIT License.

Authors

Mileto Almeida - Developer - GitHub


# OOPBank [BRA]

O **OOPBank** é um projeto de banco digital desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos (OOP). O projeto tem como objetivo criar um sistema básico de gerenciamento de contas bancárias com funcionalidades como criação de conta, login, depósitos, saques e transferências.

## Índice

- [Instalação](#instalação)
- [Uso](#uso)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Contribuição](#contribuição)
- [Licença](#licença)
- [Autores](#autores)

## Instalação

### Para Desenvolvedores

Para executar este projeto localmente, siga os passos abaixo:

1.1. Clone o repositório:
   ```bash
   git clone https://github.com/miletodev/OOPBank.git

1.2. Abra o projeto em sua IDE de preferência (por exemplo, IntelliJ IDEA).


1.3. Verifique se as dependências necessárias estão instaladas (Java JDK 17 e PostgreSQL).


1.4. Configure o banco de dados PostgreSQL conforme descrito na seção de uso.


### Para Usuários Finais (Executar o Aplicativo)

Se você deseja apenas rodar o aplicativo, siga os passos abaixo:

1.1. Baixar a JRE (Java Runtime Environment):

Caso você não tenha o Java instalado, baixe e instale a JRE (Java Runtime Environment) mais recente. Você pode fazer o download da JRE diretamente do site oficial da Oracle.

1.2. Instalar o Git:

Se você ainda não tem o Git instalado, baixe e instale o Git a partir do site oficial.

Siga as instruções de instalação conforme o seu sistema operacional.


1.3. Clonar o Repositório:

Abra o terminal (Prompt de Comando no Windows, Terminal no macOS ou Linux).

Navegue até o diretório onde você deseja baixar o projeto.

Execute o seguinte comando para clonar o repositório:

git clone https://github.com/miletodev/OOPBank.git

Isso criará uma pasta chamada OOPBank com todos os arquivos do projeto.



2. Obter o Executável do Projeto:

No repositório clonado, você deve ter um arquivo chamado OOPBank.jar. Certifique-se de que ele está na raiz do diretório do projeto.



3. Executar o Aplicativo:

No terminal, navegue até a pasta do projeto OOPBank:

cd OOPBank

Para rodar o aplicativo, use o seguinte comando:

java -jar OOPBank.jar

O sistema deve iniciar e você verá uma interface de linha de comando que permite gerenciar suas operações bancárias.



4. Configurar o Banco de Dados PostgreSQL:

O projeto utiliza um banco de dados PostgreSQL. Para configurá-lo:

Instale o PostgreSQL: Download PostgreSQL

Após a instalação, abra o psql (cliente do PostgreSQL) e execute os seguintes comandos para criar o banco de dados e a tabela:

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



5. Executar o Aplicativo:

Após configurar o banco de dados e baixar o arquivo .jar do aplicativo, você pode rodar o projeto com o seguinte comando no terminal:

java -jar OOPBank.jar

O sistema deve iniciar, apresentando uma interface de linha de comando para que você possa criar contas, fazer login e gerenciar suas operações bancárias.




## Uso

Banco de Dados

O projeto utiliza um banco de dados PostgreSQL para armazenar informações dos usuários e suas contas. Certifique-se de ter o PostgreSQL instalado e crie o banco de dados conforme o arquivo schema.sql incluído no projeto.

Execução

Após configurar o banco de dados, execute o projeto diretamente na sua IDE. O sistema apresentará uma interface de linha de comando (CLI) que permite ao usuário realizar as seguintes ações:

Criar uma nova conta bancária.

Fazer login com credenciais existentes.

Consultar saldo, fazer saques, depósitos e transferências.


## Funcionalidades

Criação de conta com geração automática de número de agência e conta.

Login seguro utilizando ID e senha.

Consultas de saldo em tempo real.

Depósitos, saques e transferências entre contas.

Persistência de dados usando PostgreSQL.


## Tecnologias Utilizadas

Java

PostgreSQL

IntelliJ IDEA


## Contribuição

Contribuições são sempre bem-vindas! Para contribuir:

1. Faça um fork do projeto.


2. Crie uma branch com a nova funcionalidade:

git checkout -b feature/nova-funcionalidade


3. Faça suas modificações e comite:

git commit -m "Adiciona nova funcionalidade"


4. Envie as alterações:

git push origin feature/nova-funcionalidade


5. Abra um Pull Request.



## Licença

Este projeto está licenciado sob a MIT License.

## Autores

Mileto Almeida - Desenvolvedor - GitHub

# OOPBank

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

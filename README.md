# OOPBank - Digital Banking System

O OOPBank é um sistema de banco digital que permite aos usuários se registrarem, fazerem login e gerenciarem suas contas bancárias. O projeto foi desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos (OOP) e inclui validações para entradas de dados, como números de telefone, e-mails e verificação de idade.

## Funcionalidades

- **Cadastro de Usuários**: Permite que novos usuários se cadastrem com informações pessoais e financeiras.
- **Login de Usuários**: Usuários registrados podem fazer login usando seu ID e senha.
- **Validações**: Implementa validações para:
  - Números de telefone (formato: +XX (XX) XXXXXXXXX)
  - E-mails (formato padrão de e-mail)
  - Idade (verifica se o usuário tem 18 anos ou mais)

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para desenvolver o sistema.
- **Apache Commons Validator**: Biblioteca para validação de e-mails.
- **JUnit** (opcional): Para testes unitários (se implementado no futuro).

## Como Executar o Projeto

   ```bash
   git clone https://github.com/miletodev/OOPBank.git
   cd OOPBank

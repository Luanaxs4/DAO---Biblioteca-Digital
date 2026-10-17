# 📚 Sistema de Biblioteca

## 📌 Sobre o projeto

O Sistema de Biblioteca é uma aplicação desenvolvida em Java para gerenciar livros e empréstimos, utilizando o Supabase como banco de dados.

O projeto foi desenvolvido com o objetivo de praticar conceitos de Programação Orientada a Objetos (POO), operações CRUD e o padrão DAO (*Data Access Object*), responsável por separar a lógica de acesso aos dados das demais partes da aplicação.

## 🚀 Funcionalidades

- **Cadastro de livros:** registra livros com título, autor e identificador.
- **Cadastro de empréstimos:** registra empréstimos associados aos livros e suas respectivas datas de retirada.
- **Listagem de livros:** consulta todos os livros cadastrados.
- **Busca por ID:** permite consultar livros e empréstimos específicos.
- **Exclusão de registros:** remove livros e empréstimos a partir de seus identificadores.

## 🛠️ Tecnologias utilizadas

- **Java:** desenvolvimento da aplicação.
- **Supabase:** serviço de banco de dados utilizado para armazenar as informações.
- **JDBC/SQL:** tecnologias utilizadas caso a implementação DAO realize a comunicação com um banco de dados relacional.
- **DAO (Data Access Object):** padrão de projeto utilizado para organizar o acesso aos dados.
- **Programação Orientada a Objetos (POO):** organização do código em classes e objetos.

## 📂 Estrutura do projeto
```text
biblioteca/
├── App.java
├── dao/
│   ├── DAO.java
│   ├── DaoLivro.java
│   └── DaoEmprestimo.java
└── model/
    ├── Livro.java
    └── Emprestimo.java

```

A classe principal (`App.java`) demonstra as operações realizadas pelo sistema:

## 🧪 Demonstração

Ao executar a aplicação, são realizadas as seguintes operações:

1. Cadastro de três livros:
   - *Como eu era antes de você* — Jojo Moyes.
   - *O diário de um banana* — Jeff Kinney.
   - *A culpa é das estrelas* — John Green.
2. Cadastro de três empréstimos vinculados aos livros.
3. Listagem de todos os livros cadastrados.
4. Busca do livro de ID `2`.
5. Busca do empréstimo de ID `3`.
6. Exclusão do empréstimo de ID `2`.
7. Exclusão do livro de ID `1`.
8. Nova listagem dos livros para verificar o resultado das operações.


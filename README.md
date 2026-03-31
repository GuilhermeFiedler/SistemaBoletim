# 📘 Sistema Boletim

Sistema de cadastro e gerenciamento de alunos, disciplinas e notas, com persistência de dados em banco PostgreSQL.  
Projeto desenvolvido em Java, utilizando Maven para gerenciamento de dependências.

---

## 🚀 Funcionalidades

- Cadastro de alunos  
- Cadastro de disciplinas  
- Lançamento e consulta de notas  
- Relacionamento aluno ↔ disciplina  
- Armazenamento persistente em banco PostgreSQL  

---

## 🛠️ Tecnologias Utilizadas

- Java (JDK 11)  
- Maven  
- PostgreSQL  
- JDBC  
- Paradigma de Programação Orientada a Objetos (POO)  

---

## ⚙️ Configuração do Banco de Dados

1. Crie o banco de dados no PostgreSQL:

```sql
CREATE DATABASE instituicaoensino;
```

2. Ajuste as credenciais de acesso no código, se necessário:
   
```java
String url = "jdbc:postgresql://localhost:5432/instituicaoensino";
String user = "seu_usuario";
String password = "sua_senha";
```
Caminho: 
```java
/src/main/java/instituicaoEnsino/config/DatabaseConnection.java
```
3. Certifique-se de que o PostgreSQL esteja em execução.
   
▶️ Como Executar o Projeto

Execute a classe principal: 
```java
/src/main/java/instituicaoEnsino/teste/Main.java
```

📌 Observações
- Certifique-se de ter o PostgreSQL instalado e rodando localmente.
- Configure corretamente o usuário e senha do banco de dados.
- Utilize o Maven para baixar automaticamente as dependências do projeto.

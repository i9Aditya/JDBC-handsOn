# JDBC Learning Project

A Java-based learning project focused on **JDBC (Java Database Connectivity)** and working with a MySQL database.

The project demonstrates how Java applications communicate with a relational database using JDBC, including database connections, CRUD operations, `PreparedStatement`, `ResultSet`, the DAO pattern, and database transactions with commit/rollback.

## 🚀 Features

* Connect Java applications to MySQL using JDBC
* Insert employee records
* Retrieve employee records by ID
* Update employee salaries
* Delete employee records
* Use `PreparedStatement` for parameterized SQL queries
* Process database results using `ResultSet`
* Implement a basic DAO (Data Access Object) layer
* Demonstrate database transactions
* Commit successful transactions
* Roll back failed transactions
* Use Java's try-with-resources for automatic resource management

## 🛠️ Technologies Used

* **Java 21**
* **Maven**
* **MySQL**
* **JDBC**
* **MySQL Connector/J**
* **IntelliJ IDEA**

## 📂 Project Structure

```text
JDBC-learning/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── example/
│   │   │           ├── BankTransaction.java
│   │   │           ├── Employee.java
│   │   │           ├── EmployeeDAO.java
│   │   │           └── Main.java
│   │   │
│   │   └── resources/
│   │
│   └── test/
│       └── java/
│
├── .gitignore
├── pom.xml
└── README.md
```

## 🧩 Project Components

### Employee

The `Employee` class represents an employee record containing:

* Employee ID
* Employee name
* Salary

It provides getters and setters for accessing and modifying employee information.

### EmployeeDAO

`EmployeeDAO` contains the database operations related to employees.

Current operations include:

```text
createEmployee()
findEmployee()
updateEmployee()
deleteEmployee()
```

This separates database-related operations from the rest of the application and introduces the **DAO design pattern**.

### Main

`Main` acts as the entry point of the application.

It establishes a MySQL database connection and uses `EmployeeDAO` to perform database operations.

### BankTransaction

`BankTransaction` demonstrates how JDBC transactions can be used for operations that require multiple database updates.

The money transfer process:

```text
Sender Account
      │
      │ Deduct money
      ▼
Receiver Account
      │
      │ Add money
      ▼
    COMMIT
```

If either operation fails:

```text
Transaction
    │
    ├── Deduct money ✓
    │
    ├── Add money ✗
    │
    ▼
  ROLLBACK
```

The implementation disables auto-commit, performs both operations, and commits only when the complete transfer succeeds.

## 🗄️ Database Setup

The project expects a MySQL database named:

```text
jdbc_learning
```

The application currently works with an `employees` table and an `accounts` table.

### Example `employees` table

```sql
CREATE DATABASE jdbc_learning;

USE jdbc_learning;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    salary DOUBLE
);
```

### Example employee data

```sql
INSERT INTO employees (name, salary)
VALUES
('Aman', 45000),
('Rohit', 50000),
('Kiran', 57000);
```

> The exact database schema required for `accounts` depends on how you want to use the `BankTransaction` example.

## ⚙️ Configuration

Before running the project, configure your MySQL connection.

The JDBC URL follows this format:

```text
jdbc:mysql://localhost:3306/jdbc_learning
```

### ⚠️ Important Security Note

Do **not** commit database credentials to GitHub.

Instead of writing credentials directly in `Main.java`, use environment variables.

For example:

```text
DB_URL=jdbc:mysql://localhost:3306/jdbc_learning
DB_USERNAME=root
DB_PASSWORD=your_password
```

Keep local configuration files containing secrets out of Git using `.gitignore`.

## 📦 Maven Dependency

The project uses the MySQL JDBC driver through Maven.

The dependency is defined in `pom.xml`:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>26.7.0</version>
</dependency>
```

## ▶️ Running the Project

### 1. Clone the repository

```bash
git clone <repository-url>
cd JDBC-learning
```

### 2. Make sure MySQL is running

Create the required database and tables.

### 3. Configure your database credentials

Set the required environment variables or local configuration.

### 4. Build the project

```bash
mvn clean install
```

### 5. Run the application

Run `Main.java` from IntelliJ IDEA or use Maven to execute the application.

## 📚 JDBC Concepts Practiced

This project is primarily a learning exercise and covers several important JDBC concepts.

### Database Connection

```java
Connection con =
    DriverManager.getConnection(url, username, password);
```

### PreparedStatement

Parameterized queries are used for database operations:

```java
PreparedStatement ps =
    con.prepareStatement(
        "UPDATE employees SET salary = ? WHERE id = ?"
    );
```

### ResultSet

Database query results are processed using:

```java
ResultSet resultSet = ps.executeQuery();
```

### CRUD Operations

The project demonstrates:

```text
Create → INSERT
Read   → SELECT
Update → UPDATE
Delete → DELETE
```

### Transactions

The `BankTransaction` class demonstrates:

```java
con.setAutoCommit(false);

con.commit();

con.rollback();
```

This provides an introduction to maintaining consistency when multiple database operations need to succeed together.

## 🎯 Learning Goals

The primary goal of this project is to build a strong foundation in database connectivity before moving toward higher-level Java backend technologies.

The concepts practiced here include:

* JDBC architecture
* SQL from Java
* Database connections
* `Statement` and `PreparedStatement`
* `ResultSet`
* CRUD operations
* DAO pattern
* Exception handling
* Try-with-resources
* Transactions
* Commit and rollback
* MySQL integration

## 🔮 Future Improvements

Possible improvements as the project evolves:

* [ ] Move database configuration to environment variables
* [ ] Add proper service layer
* [ ] Improve exception handling
* [ ] Add input validation
* [ ] Add unit and integration tests
* [ ] Implement connection pooling
* [ ] Add transaction validation
* [ ] Improve project architecture
* [ ] Add logging
* [ ] Introduce interfaces for DAO classes
* [ ] Convert the project into a Spring Boot REST API
* [ ] Replace raw JDBC operations with Spring JDBC / JPA

## 📈 Learning Progression

This project represents a step toward backend development with Java:

```text
Core Java
    ↓
Collections & OOP
    ↓
JDBC
    ↓
MySQL
    ↓
DAO Pattern
    ↓
Transactions
    ↓
Spring JDBC
    ↓
Spring Boot
    ↓
REST APIs
    ↓
Production Backend Development
```

## 👨‍💻 Author

**Aditya Mudgal**

This project is part of my journey of learning **Java, JDBC, MySQL, and backend development**.

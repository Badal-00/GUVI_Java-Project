CREATE DATABASE OnlineBankingSystem;
USE OnlineBankingSystem;

CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    DateOfBirth DATE,
    Email VARCHAR(100) UNIQUE,
    Phone VARCHAR(15),
    Address TEXT,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerID INT,
    AccountType ENUM('Savings', 'Checking', 'Credit') NOT NULL,
    Balance DECIMAL(15, 2) DEFAULT 0.0,
    AccountStatus ENUM('Active', 'Inactive', 'Closed') DEFAULT 'Active',
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY AUTO_INCREMENT,
    AccountID INT,
    TransactionType ENUM('Deposit', 'Withdrawal', 'Transfer') NOT NULL,
    Amount DECIMAL(15, 2) NOT NULL,
    TransactionDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Description VARCHAR(255),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerID INT,
    LoanType ENUM('Personal', 'Mortgage', 'Auto', 'Education') NOT NULL,
    LoanAmount DECIMAL(15, 2) NOT NULL,
    InterestRate DECIMAL(4, 2) NOT NULL,
    LoanTerm INT, -- in months
    StartDate DATE,
    EndDate DATE,
    LoanStatus ENUM('Pending', 'Approved', 'Closed') DEFAULT 'Pending',
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Cards (
    CardID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerID INT,
    AccountID INT,
    CardType ENUM('Debit', 'Credit') NOT NULL,
    CardNumber VARCHAR(16) UNIQUE NOT NULL,
    ExpirationDate DATE,
    CVV INT,
    CardStatus ENUM('Active', 'Inactive', 'Blocked') DEFAULT 'Active',
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Audits (
    AuditID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerID INT,
    Action VARCHAR(100),
    Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Details TEXT,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
package com.banking.dao;

import com.banking.model.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {
    private Connection connection;

    public TransactionDao(Connection connection) {
        this.connection = connection;
    }

   
    public void createTransaction(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO Transactions (AccountId, TransactionType, Amount, TransactionDate, Description) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transaction.getAccountId());
            stmt.setString(2, transaction.getTransactionType());
            stmt.setDouble(3, transaction.getAmount());
            stmt.setTimestamp(4, transaction.getTransactionDate());
            stmt.setString(5, transaction.getDescription());
            stmt.executeUpdate();
        }
    }

   
    public Transaction getTransactionById(int transactionId) throws SQLException {
        String sql = "SELECT * FROM Transactions WHERE TransactionID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transactionId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Transaction(
                    rs.getInt("TransactionID"),
                    rs.getInt("AccountId"),
                    rs.getString("TransactionType"),
                    rs.getDouble("Amount"),
                    rs.getTimestamp("TransactionDate"),
                    rs.getString("Description")
                );
            }
        }
        return null;
    }

    
    public List<Transaction> getTransactionsByAccountId(int accountId) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM Transactions WHERE AccountId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                transactions.add(new Transaction(
                    rs.getInt("TransactionID"),
                    rs.getInt("AccountId"),
                    rs.getString("TransactionType"),
                    rs.getDouble("Amount"),
                    rs.getTimestamp("TransactionDate"),
                    rs.getString("Description")
                ));
            }
        }
        return transactions;
    }

   
    public List<Transaction> getAllTransactions() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM Transactions";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                transactions.add(new Transaction(
                    rs.getInt("TransactionID"),
                    rs.getInt("AccountId"),
                    rs.getString("TransactionType"),
                    rs.getDouble("Amount"),
                    rs.getTimestamp("TransactionDate"),
                    rs.getString("Description")
                ));
            }
        }
        return transactions;
    }

   
    public void updateTransaction(Transaction transaction) throws SQLException {
        String sql = "UPDATE Transactions SET AccountId = ?, TransactionType = ?, Amount = ?, TransactionDate = ?, Description = ? WHERE TransactionID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transaction.getAccountId());
            stmt.setString(2, transaction.getTransactionType());
            stmt.setDouble(3, transaction.getAmount());
            stmt.setTimestamp(4, transaction.getTransactionDate());
            stmt.setString(5, transaction.getDescription());
            stmt.setInt(6, transaction.getTransactionId());
            stmt.executeUpdate();
        }
    }

    
    public void deleteTransaction(int transactionId) throws SQLException {
        String sql = "DELETE FROM Transactions WHERE TransactionID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transactionId);
            stmt.executeUpdate();
        }
    }
}
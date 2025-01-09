package com.banking.dao;

import com.banking.model.Account;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    private Connection connection;

    public AccountDao(Connection connection) {
        this.connection = connection;
    }

   
    public void createAccount(Account account) throws SQLException {
        String sql = "INSERT INTO Accounts (CustomerId, AccountType, Balance, AccountStatus, CreatedAt) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, account.getCustomerId());
            stmt.setString(2, account.getAccountType());
            stmt.setDouble(3, account.getBalance());
            stmt.setString(4, account.getAccountStatus());
            stmt.setTimestamp(5, account.getCreatedAt());
            stmt.executeUpdate();
        }
    }

   
    public Account getAccountById(int accountId) throws SQLException {
        String sql = "SELECT * FROM Accounts WHERE AccountId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Account(
                    rs.getInt("AccountId"),
                    rs.getInt("CustomerId"),
                    rs.getString("AccountType"),
                    rs.getDouble("Balance"),
                    rs.getString("AccountStatus"),
                    rs.getTimestamp("CreatedAt")
                );
            }
        }
        return null;
    }

   
    public List<Account> getAllAccounts() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM Accounts";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                accounts.add(new Account(
                    rs.getInt("AccountId"),
                    rs.getInt("CustomerId"),
                    rs.getString("AccountType"),
                    rs.getDouble("Balance"),
                    rs.getString("AccountStatus"),
                    rs.getTimestamp("CreatedAt")
                ));
            }
        }
        return accounts;
    }

   
    public void updateAccount(Account account) throws SQLException {
        String sql = "UPDATE Accounts SET CustomerId = ?, AccountType = ?, Balance = ?, AccountStatus = ?, CreatedAt = ? WHERE AccountId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, account.getCustomerId());
            stmt.setString(2, account.getAccountType());
            stmt.setDouble(3, account.getBalance());
            stmt.setString(4, account.getAccountStatus());
            stmt.setTimestamp(5, account.getCreatedAt());
            stmt.setInt(6, account.getAccountId());
            stmt.executeUpdate();
        }
    }

   
    public void deleteAccount(int accountId) throws SQLException {
        String sql = "DELETE FROM Accounts WHERE AccountId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, accountId);
            stmt.executeUpdate();
        }
    }
}
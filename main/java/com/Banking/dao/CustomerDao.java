package com.Banking.dao;

import com.Banking.model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private Connection connection;

    public CustomerDao(Connection connection) {
        this.connection = connection;
    }

   
    public void createCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO Customers (FirstName, LastName, DateOfBirth, Email, Phone, Address, CreatedAt) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setDate(3, customer.getDateOfBirth());
            stmt.setString(4, customer.getEmail());
            stmt.setString(5, customer.getPhone());
            stmt.setString(6, customer.getAddress());
            stmt.setTimestamp(7, customer.getCreatedAt());
            stmt.executeUpdate();
        }
    }

   
    public Customer getCustomerById(int customerId) throws SQLException {
        String sql = "SELECT * FROM Customers WHERE CustomerID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Customer(
                    rs.getInt("CustomerID"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getDate("DateOfBirth"),
                    rs.getString("Email"),
                    rs.getString("Phone"),
                    rs.getString("Address"),
                    rs.getTimestamp("CreatedAt")
                );
            }
        }
        return null;
    }

   
    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM Customers";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                customers.add(new Customer(
                    rs.getInt("CustomerID"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getDate("DateOfBirth"),
                    rs.getString("Email"),
                    rs.getString("Phone"),
                    rs.getString("Address"),
                    rs.getTimestamp("CreatedAt")
                ));
            }
        }
        return customers;
    }

    
    public void updateCustomer(Customer customer) throws SQLException {
        String sql = "UPDATE Customers SET FirstName = ?, LastName = ?, DateOfBirth = ?, Email = ?, Phone = ?, Address = ?, CreatedAt = ? WHERE CustomerID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setDate(3, customer.getDateOfBirth());
            stmt.setString(4, customer.getEmail());
            stmt.setString(5, customer.getPhone());
            stmt.setString(6, customer.getAddress());
            stmt.setTimestamp(7, customer.getCreatedAt());
            stmt.setInt(8, customer.getCustomerId());
            stmt.executeUpdate();
        }
    }

    
    public void deleteCustomer(int customerId) throws SQLException {
        String sql = "DELETE FROM Customers WHERE CustomerID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            stmt.executeUpdate();
        }
    }
}

package com.Banking.dao;

import com.Banking.model.Loan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanDao {
    private Connection connection;

    public LoanDao(Connection connection) {
        this.connection = connection;
    }

  
    public void createLoan(Loan loan) throws SQLException {
        String sql = "INSERT INTO Loans (CustomerId, LoanType, LoanAmount, InterestRate, LoanTerm, StartDate, EndDate, LoanStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, loan.getCustomerId());
            stmt.setString(2, loan.getLoanType());
            stmt.setDouble(3, loan.getLoanAmount());
            stmt.setDouble(4, loan.getInterestRate());
            stmt.setInt(5, loan.getLoanTerm());
            stmt.setDate(6, loan.getStartDate());
            stmt.setDate(7, loan.getEndDate());
            stmt.setString(8, loan.getLoanStatus());
            stmt.executeUpdate();
        }
    }

    
    public Loan getLoanById(int loanId) throws SQLException {
        String sql = "SELECT * FROM Loans WHERE LoanID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, loanId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Loan(
                    rs.getInt("LoanID"),
                    rs.getInt("CustomerId"),
                    rs.getString("LoanType"),
                    rs.getDouble("LoanAmount"),
                    rs.getDouble("InterestRate"),
                    rs.getInt("LoanTerm"),
                    rs.getDate("StartDate"),
                    rs.getDate("EndDate"),
                    rs.getString("LoanStatus")
                );
            }
        }
        return null;
    }

   
    public List<Loan> getLoansByCustomerId(int customerId) throws SQLException {
        List<Loan> loans = new ArrayList<>();
        String sql = "SELECT * FROM Loans WHERE CustomerId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                loans.add(new Loan(
                    rs.getInt("LoanID"),
                    rs.getInt("CustomerId"),
                    rs.getString("LoanType"),
                    rs.getDouble("LoanAmount"),
                    rs.getDouble("InterestRate"),
                    rs.getInt("LoanTerm"),
                    rs.getDate("StartDate"),
                    rs.getDate("EndDate"),
                    rs.getString("LoanStatus")
                ));
            }
        }
        return loans;
    }

    
    public List<Loan> getAllLoans() throws SQLException {
        List<Loan> loans = new ArrayList<>();
        String sql = "SELECT * FROM Loans";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                loans.add(new Loan(
                    rs.getInt("LoanID"),
                    rs.getInt("CustomerId"),
                    rs.getString("LoanType"),
                    rs.getDouble("LoanAmount"),
                    rs.getDouble("InterestRate"),
                    rs.getInt("LoanTerm"),
                    rs.getDate("StartDate"),
                    rs.getDate("EndDate"),
                    rs.getString("LoanStatus")
                ));
            }
        }
        return loans;
    }

    
    public void updateLoan(Loan loan) throws SQLException {
        String sql = "UPDATE Loans SET CustomerId = ?, LoanType = ?, LoanAmount = ?, InterestRate = ?, LoanTerm = ?, StartDate = ?, EndDate = ?, LoanStatus = ? WHERE LoanID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, loan.getCustomerId());
            stmt.setString(2, loan.getLoanType());
            stmt.setDouble(3, loan.getLoanAmount());
            stmt.setDouble(4, loan.getInterestRate());
            stmt.setInt(5, loan.getLoanTerm());
            stmt.setDate(6, loan.getStartDate());
            stmt.setDate(7, loan.getEndDate());
            stmt.setString(8, loan.getLoanStatus());
            stmt.setInt(9, loan.getLoanId());
            stmt.executeUpdate();
        }
    }

    
    public void deleteLoan(int loanId) throws SQLException {
        String sql = "DELETE FROM Loans WHERE LoanID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, loanId);
            stmt.executeUpdate();
        }
    }
}

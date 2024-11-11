package com.Banking.dao;

import com.Banking.model.Audit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuditDao {
    private Connection connection;

    public AuditDao(Connection connection) {
        this.connection = connection;
    }

   
    public boolean addAudit(Audit audit) {
        String sql = "INSERT INTO Audit (auditId, customerId, action, timestamp, details) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, audit.getAuditId());
            stmt.setInt(2, audit.getCustomerId());
            stmt.setString(3, audit.getAction());
            stmt.setTimestamp(4, audit.getTimestamp());
            stmt.setString(5, audit.getDetails());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

   
    public Audit getAuditById(int auditId) {
        String sql = "SELECT * FROM Audit WHERE auditId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, auditId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToAudit(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    
    public List<Audit> getAllAudits() {
        List<Audit> audits = new ArrayList<>();
        String sql = "SELECT * FROM Audit";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                audits.add(mapResultSetToAudit(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return audits;
    }

    
    public boolean updateAudit(Audit audit) {
        String sql = "UPDATE Audit SET customerId = ?, action = ?, timestamp = ?, details = ? WHERE auditId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, audit.getCustomerId());
            stmt.setString(2, audit.getAction());
            stmt.setTimestamp(3, audit.getTimestamp());
            stmt.setString(4, audit.getDetails());
            stmt.setInt(5, audit.getAuditId());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean deleteAudit(int auditId) {
        String sql = "DELETE FROM Audit WHERE auditId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, auditId);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    private Audit mapResultSetToAudit(ResultSet rs) throws SQLException {
        Audit audit = new Audit();
        audit.setAuditId(rs.getInt("auditId"));
        audit.setCustomerId(rs.getInt("customerId"));
        audit.setAction(rs.getString("action"));
        audit.setTimestamp(rs.getTimestamp("timestamp"));
        audit.setDetails(rs.getString("details"));
        return audit;
    }
}

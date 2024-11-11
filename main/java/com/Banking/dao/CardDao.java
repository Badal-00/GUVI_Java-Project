package com.Banking.dao;

import com.Banking.model.Card;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardDao {
    private Connection connection;

    public CardDao(Connection connection) {
        this.connection = connection;
    }

   
    public boolean addCard(Card card) {
        String sql = "INSERT INTO Card (cardId, customerId, accountId, cardType, cardNumber, expirationDate, cvv, cardStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, card.getCardId());
            stmt.setInt(2, card.getCustomerId());
            stmt.setInt(3, card.getAccountId());
            stmt.setString(4, card.getCardType());
            stmt.setString(5, card.getCardNumber());
            stmt.setDate(6, card.getExpirationDate());
            stmt.setInt(7, card.getCvv());
            stmt.setString(8, card.getCardStatus());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public Card getCardById(int cardId) {
        String sql = "SELECT * FROM Card WHERE cardId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cardId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToCard(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

   
    public List<Card> getAllCards() {
        List<Card> cards = new ArrayList<>();
        String sql = "SELECT * FROM Card";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cards.add(mapResultSetToCard(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

   
    public boolean updateCard(Card card) {
        String sql = "UPDATE Card SET customerId = ?, accountId = ?, cardType = ?, cardNumber = ?, expirationDate = ?, cvv = ?, cardStatus = ? WHERE cardId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, card.getCustomerId());
            stmt.setInt(2, card.getAccountId());
            stmt.setString(3, card.getCardType());
            stmt.setString(4, card.getCardNumber());
            stmt.setDate(5, card.getExpirationDate());
            stmt.setInt(6, card.getCvv());
            stmt.setString(7, card.getCardStatus());
            stmt.setInt(8, card.getCardId());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean deleteCard(int cardId) {
        String sql = "DELETE FROM Card WHERE cardId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cardId);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    private Card mapResultSetToCard(ResultSet rs) throws SQLException {
        Card card = new Card();
        card.setCardId(rs.getInt("cardId"));
        card.setCustomerId(rs.getInt("customerId"));
        card.setAccountId(rs.getInt("accountId"));
        card.setCardType(rs.getString("cardType"));
        card.setCardNumber(rs.getString("cardNumber"));
        card.setExpirationDate(rs.getDate("expirationDate"));
        card.setCvv(rs.getInt("cvv"));
        card.setCardStatus(rs.getString("cardStatus"));
        return card;
    }
}

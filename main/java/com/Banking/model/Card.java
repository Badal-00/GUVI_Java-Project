package com.Banking.model;
import java.sql.Date;



public class Card {
	private int cardId;
    private int customerId;
    private int accountId;
    private String cardType;
    private String cardNumber;
    private Date expirationDate;
    private int cvv;
    private String cardStatus;
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Card(int cardId, int customerId, int accountId, String cardType, String cardNumber, Date expirationDate,
			int cvv, String cardStatus) {
		super();
		this.cardId = cardId;
		this.customerId = customerId;
		this.accountId = accountId;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
		this.cardStatus = cardStatus;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public String getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}
	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", customerId=" + customerId + ", accountId=" + accountId + ", cardType="
				+ cardType + ", cardNumber=" + cardNumber + ", expirationDate=" + expirationDate + ", cvv=" + cvv
				+ ", cardStatus=" + cardStatus + "]";
	}



}

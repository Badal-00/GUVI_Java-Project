package com.banking.model;
import java.sql.Timestamp;


public class Account {
	private int accountId;
    private int customerId;
	private String accountType;
    private double balance;
    private String accountStatus;
    private Timestamp createdAt;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountId, int customerId, String accountType, double balance, String accountStatus,
			Timestamp createdAt) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountType = accountType;
		this.balance = balance;
		this.accountStatus = accountStatus;
		this.createdAt = createdAt;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", customerId=" + customerId + ", accountType=" + accountType
				+ ", balance=" + balance + ", accountStatus=" + accountStatus + ", createdAt=" + createdAt + "]";
	}



}
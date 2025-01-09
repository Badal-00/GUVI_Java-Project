package com.banking.model;
import java.sql.Date;


public class Loan {
	private int loanId;
    private int customerId;
    private String loanType;
    private double loanAmount;
    private double interestRate;
    private int loanTerm;
    private Date startDate;
    private Date endDate;
    private String loanStatus;
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loan(int loanId, int customerId, String loanType, double loanAmount, double interestRate, int loanTerm,
			Date startDate, Date endDate, String loanStatus) {
		super();
		this.loanId = loanId;
		this.customerId = customerId;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.loanTerm = loanTerm;
		this.startDate = startDate;
		this.endDate = endDate;
		this.loanStatus = loanStatus;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getLoanTerm() {
		return loanTerm;
	}
	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", customerId=" + customerId + ", loanType=" + loanType + ", loanAmount="
				+ loanAmount + ", interestRate=" + interestRate + ", loanTerm=" + loanTerm + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", loanStatus=" + loanStatus + "]";
	}

    

}
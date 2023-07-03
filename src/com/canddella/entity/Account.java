package com.canddella.entity;

import java.time.LocalDate;

public class Account {
	private String accountNo;
	private String accountType;
	private LocalDate accountCreateDate;
	private double accountBalance;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public LocalDate getAccountCreateDate() {
		return accountCreateDate;
	}
	public void setAccountCreateDate(LocalDate accountCreateDate) {
		this.accountCreateDate = accountCreateDate;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Account(String accountNo, String accountType, LocalDate accountCreateDate, double accountBalance) {
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.accountCreateDate = accountCreateDate;
		this.accountBalance = accountBalance;
	}
	
	
	
	

}

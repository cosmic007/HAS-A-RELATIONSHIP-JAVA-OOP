package com.canddella.entity;

import java.util.ArrayList;

public class Customer {
	
	private String customerCode;
	private String customerName;
	private String customerType;
	private ArrayList <Account> accountList;
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public ArrayList<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}
	public Customer(String customerCode, String customerName, String customerType, ArrayList<Account> accountList) {
		super();
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.customerType = customerType;
		this.accountList = accountList;
	}
	
	

}

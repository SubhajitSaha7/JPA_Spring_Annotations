package com.cg.dto;

public class AccountDto {
	
	private String customerName;
	private Double balance;
	public AccountDto(String customerName, Double balance) {
		super();
		this.customerName = customerName;
		this.balance = balance;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	

}

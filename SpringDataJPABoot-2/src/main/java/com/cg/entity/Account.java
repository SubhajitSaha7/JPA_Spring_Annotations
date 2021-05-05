package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cg_account")
public class Account {
	
	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	@SequenceGenerator(name="seq1", sequenceName = "acc_seq1", allocationSize = 1)
	private Integer accountId;
	
	@Column(name="cust_name", length=25)
	private String custName;
	
	@Column(name="balance")
	private Double balance;
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return  accountId + " " +  custName + " " +  balance ;
	}
	

}

package com.cg.service;

import com.cg.dto.AccountDto;
import com.cg.entity.Account;
import com.cg.exceptions.AccountException;
import com.cg.exceptions.BalanceException;

public interface IAccountService {
	
	public Integer addAccount(AccountDto dto) throws BalanceException;
	
	public Account getAccount(int aid) throws AccountException;
	
	public boolean transferFund(int fromaid, int toaid, double amount) throws AccountException, BalanceException;
	
	

}

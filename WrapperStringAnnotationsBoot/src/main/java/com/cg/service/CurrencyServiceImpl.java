package com.cg.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myser")
public class CurrencyServiceImpl implements ICurrencyService{

	@Value("${state}")
	private String msg;
	@Value("${rate}")
	private double rate;


	@Override
	public double convertToINR(double usd) {
		
		return rate* usd;
	}

	@Override
	public String currentState() {
		
		return msg +" current rate id "+rate;
	}
	
	

}

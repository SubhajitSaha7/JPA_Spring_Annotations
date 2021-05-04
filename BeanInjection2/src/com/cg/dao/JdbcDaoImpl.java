package com.cg.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("jdbcdao")
@Repository("jdbcdao")
@Lazy(true)
public class JdbcDaoImpl implements IDao{
	
	public JdbcDaoImpl() {
		System.out.println("JDBC Dao Constructor");
	}

	
	@Override
	public String getEmployee() {
		return "jdbc";
	}

}

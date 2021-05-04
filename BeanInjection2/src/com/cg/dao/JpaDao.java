package com.cg.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

//@Component("jpadao")
@Repository("jpadao")
@Lazy
public class JpaDao implements IDao{

	public JpaDao() {
		System.out.println("jdbc dao constructor");
	}
	@Override
	public String getEmployee() {
		
		return "jpa";
	}

}

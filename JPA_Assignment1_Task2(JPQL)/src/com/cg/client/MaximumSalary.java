package com.cg.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.entity.Emp;

public class MaximumSalary {
	public static void main(String[] args) {
		
		EntityManagerFactory fac= Persistence.createEntityManagerFactory("JPA-CRUD");
		EntityManager em= fac.createEntityManager();
		String jpql="from Emp where empSal = (select max(empSal) from Emp)";
		Query qry= em.createQuery(jpql);
		List<Emp> lst= qry.getResultList();
		
		em.close();
		fac.close();
		
		lst.forEach(System.out:: println);
		
	}

}

package com.cg.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.entity.Dept;
import com.cg.entity.Emp;

public class JoinDemo3 {
	public static void main(String[] args) {
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("JPA-CRUD");
		EntityManager em= fac.createEntityManager();
		String jpql="from Dept d inner join fetch d.employees where d.deptName=:dname";
		TypedQuery<Dept> qry=em.createQuery(jpql,Dept.class);
		qry.setParameter("dname", "hr");
		Dept dept= qry.getSingleResult();
		em.close();
		fac.close();
		dept.getEmployees().forEach(System.out::println);
	}

}

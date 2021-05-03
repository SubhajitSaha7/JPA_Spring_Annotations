package com.cg.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.entity.Emp;

public class WhereDemo {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-CRUD");
		EntityManager em = emf.createEntityManager();
		String jpql = "from Emp where empDept = :dname";
		TypedQuery<Emp> qry = em.createQuery(jpql, Emp.class);
		qry.setParameter("dname", "Hr");
		List<Emp> eList = qry.getResultList();
		em.close();
		emf.close();
		eList.forEach(System.out::println);
		
	}

}

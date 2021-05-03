package com.cg.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddDept {
	public static void main(String[] args) {
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("JPA-CRUD");
		EntityManager em = fac.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Dept d1 = new Dept();
		d1.setDeptName("hr");
		
		Dept d2 = new Dept();
		d2.setDeptName("production");
		
		em.persist(d1);
		em.persist(d2);
		tx.commit();
		em.close();
		fac.close();
		System.out.println("dept inserted");
	}
}

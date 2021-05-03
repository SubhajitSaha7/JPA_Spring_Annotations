package com.cg.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Query;

public class UpdateQuery {
	public static void main(String[] args) {
		
		EntityManagerFactory fac= Persistence.createEntityManagerFactory("JPA-CRUD");
		EntityManager em= fac.createEntityManager();
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		String jpql="update Emp set empSal=:sal where empId=:eid";
		javax.persistence.Query qry= em.createQuery(jpql);
		qry.setParameter("sal", 30000.0);
		qry.setParameter("eid", 1003);
		
		int rows= qry.executeUpdate();
		tx.commit();
		em.close();
		fac.close();
		
			System.out.println(rows);
	}

}

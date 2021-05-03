package com.cg.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.entity.Emp;

public class DeleteEmp {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-CRUD");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try	{
			tx = em.getTransaction();
			tx.begin();
			Emp emp = em.find(Emp.class, 1004);
			em.remove(emp);
			tx.commit();
			System.out.println("row delete");
		}	catch (Exception e)	{
			System.out.println(e.getMessage());
			if (tx!=null)
				tx.rollback();
		}
		em.close();
		emf.close();
	}

}

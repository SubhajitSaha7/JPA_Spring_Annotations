package com.cg.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.entity.Emp;

public class UpdateEmp {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-CRUD");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try	{
			tx = em.getTransaction();
			tx.begin();
			Emp emp = em.find(Emp.class, 1004);
			emp.setEmpSal(4500.0);
			tx.commit();
			System.out.println("row updated");
		}	catch (Exception e)	{
			System.out.println(e.getMessage());
			if(tx!=null)
				tx.rollback();
		}
		em.close();
		emf.close();
	}

}

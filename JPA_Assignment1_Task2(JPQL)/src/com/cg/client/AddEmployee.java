package com.cg.client;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.entity.Emp;

public class AddEmployee {
	public static void main(String[] args) {
		
		Emp emp = new Emp();
		emp.setEmpId(1004);
		emp.setEmpName("Rakseh Kumar");
		emp.setEmpSal(38000.0);
		emp.setEmpDept("Hr");
		emp.setEmpDoj(LocalDate.of(2017, 8, 21));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-CRUD");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(emp);
			tx.commit();
			System.out.println("row inserted");
		}	catch (Exception e)	{
			System.out.println(e.getMessage());
			if (tx != null) 
				tx.rollback();
		}
		em.close();
		emf.close();
		
		
	}

}

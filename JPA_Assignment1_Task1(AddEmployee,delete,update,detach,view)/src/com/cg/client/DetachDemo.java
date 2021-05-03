package com.cg.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.entity.Emp;

public class DetachDemo {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-CRUD");
	
	public static void main(String[] args) {
		
		Emp emp = getEmployee(1005);
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		emp.setEmpSal(23000.0);
		em.merge(emp);
		tx.commit();
		em.close();
		emf.close();
			
	}

	private static Emp getEmployee(int eid) {
		EntityManager em = emf.createEntityManager();
		Emp emp = em.find(Emp.class, eid);
		em.close();
		return emp;
	}

	
}

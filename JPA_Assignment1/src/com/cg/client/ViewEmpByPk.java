package com.cg.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.Emp;

public class ViewEmpByPk {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-CRUD");
		EntityManager em = emf.createEntityManager();
		
		Emp emp = em.find(Emp.class, 1003);
		System.out.println(emp);
		em.detach(emp);
		
		Emp emp1 = em.find(Emp.class, 1003);
		System.out.println(emp1);
		em.close();
		emf.close();
		
	}

}

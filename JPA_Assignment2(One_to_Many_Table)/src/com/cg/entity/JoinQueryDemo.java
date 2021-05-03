package com.cg.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JoinQueryDemo {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-CRUD");
	public static void main(String[] args) {
		
		EntityManager em = emf.createEntityManager();
		
		String jpql = "from Emp e inner join fetch e.dept";
		TypedQuery<Emp> qry = em.createQuery(jpql, Emp.class);
		List<Emp> list = qry.getResultList();
		em.close();
		emf.close();
		list.forEach(emp -> {
			System.out.println(emp);
			System.out.println(emp.getDept());
			System.out.println("-----------------------------");
		});
	}

}

package com.cg.client;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.entity.Emp;

public class DateYearDemo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-CRUD");
		EntityManager em = emf.createEntityManager();
		String jpql = "from Emp where doj between :start and :end";
		Query qry = em.createQuery(jpql);
		qry.setParameter("start", LocalDate.of(2014, 03, 03));
		qry.setParameter("eid", LocalDate.of(2019, 07, 13));
		List<Emp> elist = qry.getResultList();
		em.close();
		emf.close();
		
		elist.forEach(System.out::println);
		
	}

}

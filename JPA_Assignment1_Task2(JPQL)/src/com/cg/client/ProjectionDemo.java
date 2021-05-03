package com.cg.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProjectionDemo {
	public static void main(String[] args) {
		
		EntityManagerFactory fac= Persistence.createEntityManagerFactory("JPA-CRUD");
		EntityManager em= fac.createEntityManager();
		String jpql= "select empName,empSal from Emp";
		Query qry=em.createQuery(jpql);
		
		List<Object[]> lst= qry.getResultList();
		em.clear();
		fac.close();
		for (Object arr[]: lst)
			System.out.println(arr[0]+ " "+arr[1]);
	}

}

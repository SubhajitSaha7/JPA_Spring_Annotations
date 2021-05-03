package com.cg.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GroupByDemo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-CRUD");
		EntityManager em = emf.createEntityManager();
		String jpql = "select empDept, sum(empSal), count(empId) from Emp group by empDept";
		Query qry = em.createQuery(jpql);
		List<Object[]> results = qry.getResultList();
		em.close();
		emf.close();
		
		for(Object[] arr : results)	{
			System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
		}
		
	}

}

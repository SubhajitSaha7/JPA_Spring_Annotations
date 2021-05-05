package com.cg.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

//to display employee for the given department name:-

import com.cg.entity.Emp;

public class JoinDemo2 {
	public static void main(String[] args) {
		
		EntityManagerFactory fac= Persistence.createEntityManagerFactory("JPA-CRUD");
		EntityManager em=fac.createEntityManager();
		String jpql="from Emp e inner join fetch e.dept d where d.deptName=:dname";
		TypedQuery<Emp> qry=em.createQuery(jpql,Emp.class);
		qry.setParameter("dname","hr");
		List<Emp> lst=qry.getResultList();
		em.close();
		fac.close();
		for(Emp emp:lst)
		{
			System.out.println(emp);
			System.out.println(emp.getDept());
			System.out.println("--------------------------------------------------");
		}
	}

}

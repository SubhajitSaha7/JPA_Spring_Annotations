package com.cg.client;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.entity.Dept;
import com.cg.entity.Emp;

public class AddEmployee {
	public static void main(String[] args) {
		
		EntityManagerFactory fac= Persistence.createEntityManagerFactory("JPA-CRUD");
		EntityManager em= fac.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Dept dept= em.find(Dept.class, 4);
		Emp emp=new Emp();
		emp.setEmpName("ram shyam");
		emp.setEmpSal(33000.0);
		emp.setEmpDoj(LocalDate.of(2018, 9, 18));
		emp.setDept(dept);
		em.persist(emp);
		tx.commit();
		em.close();
		fac.close();
		System.out.println("employee inserted");
	}

}

package com.cg.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.entity.Dept;
import com.cg.entity.Emp;

@Repository("mydao")
public class EmpDaoImpl implements IEmpDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Emp> viewEmployee() {
		TypedQuery<Emp> qry=em.createQuery("from Emp e inner join fetch e.dept",Emp.class);
		List<Emp> lst=qry.getResultList();
		return lst;
	}

	@Override
	public Emp addEmployee(Emp emp) {
		em.persist(emp);
		return emp;
	}
	@Override
    public List<Dept> getDepartments() {
        TypedQuery<Dept> qry = em.createQuery("from Dept", Dept.class);
     
        return qry.getResultList();
    }

	@Override
	public List<Emp> viewEmployee(String dept) {
		String jpql="from Emp e inner join fetch e.dept d where d.deptName=:dname";
		TypedQuery<Emp> qry=em.createNamedQuery(jpql, Emp.class);
		qry.setParameter("dname", dept);
		return qry.getResultList();
	}

	@Override
	public List<Emp> viewEmployee(LocalDate startDt, LocalDate endDt) {
		String jpql="from Emp e inner join fetch e.dept d where e.empDoj>=:startdoj and e.empDoj<=:enddoj";
		TypedQuery<Emp> qry=em.createNamedQuery(jpql, Emp.class);
		qry.setParameter("dname", startDt);
		qry.setParameter("dname", endDt);
		return qry.getResultList();
		
	}

	@Override
	public Emp viewEmployee(int eid) {
		
		return em.find(Emp.class,eid);
	}

	@Override
	public boolean editEmployee(Emp emp) {
		em.merge(emp);
		return true;
	}


	@Override
	public Integer getMaxId() {
		TypedQuery<Integer> qry = em.createQuery("select max(empId) from Emp",Integer.class);
	     
        return qry.getSingleResult();
	}

	@Override
	public Dept getDepartment(String deptName) {
		String jpql="from dept where deptName=:dname";
		TypedQuery<Dept> qry=em.createQuery(jpql, Dept.class);
		qry.setParameter("dname", deptName);
		return qry.getSingleResult();
	
	}

	@Override
	public boolean removeEmployee(Emp emp) {
		em.remove(emp);
		return true;
	}


}

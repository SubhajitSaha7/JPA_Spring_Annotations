package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Emp;

@Repository
public interface IEmpDao extends JpaRepository<Emp, Integer>{
	@Query("from Emp e inner join fetch e.dept d where d.deptName = :dname")
	public List<Emp> viewEmployee(@Param("dname")String deptName);
}

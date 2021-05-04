package com.cg.service;

import java.util.List;

import com.cg.dto.EmpDto;
import com.cg.entity.Emp;
import com.cg.exceptions.DeptException;
import com.cg.exceptions.EmpNotFoundException;

public interface IEmpService {
	public Integer addEmployee(EmpDto empdto) throws DeptException;

	public List<Emp> viewEmployee() throws EmpNotFoundException;

	public Emp viewEmployee(int eid) throws EmpNotFoundException;

	public List<Emp> viewEmployee(String deptName) throws EmpNotFoundException;
}

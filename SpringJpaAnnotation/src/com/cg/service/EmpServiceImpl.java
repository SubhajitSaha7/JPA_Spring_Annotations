package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.IEmpDao;
import com.cg.dto.EmpDto;
import com.cg.entity.Dept;
import com.cg.entity.Emp;
import com.cg.exceptions.DeptException;
import com.cg.exceptions.EmpIDException;
import com.cg.exceptions.EmpNotFoundException;

@Service("myservice")
@Transactional(readOnly = true)
public class EmpServiceImpl implements IEmpService {
    
	@Autowired
	private IEmpDao dao;

	@Override
	@Transactional(readOnly=false)
	public Integer addEmployee(EmpDto empdto) throws DeptException {
		Emp emp = new Emp();
		emp.setEmpName(empdto.getEmpName());
		emp.setEmpSal(empdto.getEmpSal());
		emp.setEmpDoj(empdto.getDoj());
		Dept dept = null;
		try{
			dept= dao.getDepartment(empdto.getDeptName());
		}
		catch(NoResultException ex) {
			throw new DeptException("no department found");
		}
		emp.setDept(dept);
		Emp persistedEmp=dao.addEmployee(emp);
		return persistedEmp.getEmpId();
		}

	
	@Override
	public List<Emp> viewEmployee() throws EmpNotFoundException {
		List<Emp> lst = dao.viewEmployee();
		if(lst.isEmpty())
			throw new EmpNotFoundException("No Employee Found");
		lst.sort((e1,e2)->e1.getEmpName().compareTo(e2.getEmpName()));
		return lst;
	}


	@Override
	public List<Emp> viewEmployee(String dept) throws EmpNotFoundException {
		List<Emp> elist = dao.viewEmployee(dept);
		if(elist.size()<=0)
			throw new EmpNotFoundException("No Employee Found");
		elist.sort((e1,e2)->Double.valueOf(e2.getEmpSal()).compareTo(e1.getEmpSal()));
		return elist;
	}


	@Override
	public List<Emp> viewEmployee(LocalDate startDOJ, LocalDate endDOJ) throws EmpNotFoundException {
		List<Emp> lst = dao.viewEmployee(startDOJ,endDOJ);
		if(lst.isEmpty())
			throw new EmpNotFoundException("No Employee Found");
		lst.sort((e1,e2)->e1.getEmpDoj().compareTo(e2.getEmpDoj()));
		return lst;
	}


	@Override
	public Emp viewEmployee(int eid) throws EmpNotFoundException {
		Emp emp=(Emp) dao.viewEmployee(eid);
		if(emp == null)
			throw new EmpNotFoundException("employee not found for the id"+eid);
		return emp;
	}


	@Override
	public boolean editEmmployee(EmpDto empdto) throws DeptException, EmpNotFoundException {
		
		Emp emp = dao.viewEmployee(empdto.getEmpId());
		if(emp==null)
			throw new EmpNotFoundException("no employee found");
		emp.setEmpName(empdto.getEmpName());
		emp.setEmpSal(empdto.getEmpSal());
		emp.setEmpDoj(empdto.getDoj());
		Dept dept = null;
		try{
			dept= dao.getDepartment(empdto.getDeptName());
			emp.setDept(dept);
			dao.editEmployee(emp);
			return true;
		}
		catch(NoResultException ex) {
			throw new DeptException("no department found");
		}
		
	}


	@Override
	public boolean removeEmmployee(int eid) throws EmpNotFoundException {
		Emp emp= dao.viewEmployee(eid);
		if(emp == null)
			throw new EmpNotFoundException("employee not found for the id"+eid);
		return dao.removeEmployee(emp);
	}
	
	
}

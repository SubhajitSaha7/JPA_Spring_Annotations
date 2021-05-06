package com.cg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.IDeptDao;
import com.cg.dao.IEmpDao;
import com.cg.dto.EmpDto;
import com.cg.entity.Dept;
import com.cg.entity.Emp;
import com.cg.exceptions.DeptException;
import com.cg.exceptions.EmpNotFoundException;

@Service("myser")
@Transactional
public class EmpServiceImpl implements IEmpService {
	@Autowired
	private IEmpDao empdao;
	@Autowired
	private IDeptDao deptdao;

	@Override
	@Transactional
	public Integer addEmployee(EmpDto empdto) throws DeptException {
		Emp emp = new Emp();
		emp.setEmpName(empdto.getEmpName());
		emp.setEmpSal(empdto.getEmpSal());
		emp.setEmpDoj(empdto.getDoj());
		Dept dept = null;

		dept = deptdao.findByDeptName(empdto.getDeptName());
		if (dept == null) {
			throw new DeptException("No department found");
		}
		emp.setDept(dept);
		Emp persistedEmp = empdao.save(emp);
		return persistedEmp.getEmpId();
	}

	@Override
	public List<Emp> viewEmployee() throws EmpNotFoundException {
		// TODO Auto-generated method stub
		List<Emp> lst = empdao.findAll();
		if (lst.isEmpty()) {
			throw new EmpNotFoundException("No employee found");
		}
		lst.sort((e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName()));
		return lst;
	}

	@Override
	public Emp viewEmployee(int eid) throws EmpNotFoundException {
		// TODO Auto-generated method stub
		Optional<Emp> optemp = empdao.findById(eid);
		if (!optemp.isPresent()) {
			throw new EmpNotFoundException("No employee found for id" + eid);
		}
		return optemp.get();
	}

	@Override
	public List<Emp> viewEmployee(String deptName) throws EmpNotFoundException {
		// TODO Auto-generated method stub
		List<Emp> lst = empdao.viewEmployee(deptName);
		if (lst.isEmpty()) {
			throw new EmpNotFoundException("No employee found");
		}
		lst.sort((e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName()));
		return lst;
	}
	
	/*@Override
	public boolean editEmmployee(EmpDto empdto) throws DeptException, EmpNotFoundException {
		Optional<Emp> optemp = empdao.findById(empdto.getEmpId());
		if(!optemp.isPresent())
			throw new EmpNotFoundException("No employee found");
		Emp emp = optemp.get();
		emp.setEmpName(empdto.getEmpName());
		emp.setEmpSal(empdto.getEmpSal());
		emp.setEmpDoj(empdto.getDoj());
		Dept dept = null;
		dept = deptdao.findByDeptName(empdto.getDeptName());
		if(dept == null)
			throw new DeptException("no department found");
		emp.setDept(dept);
		Emp persistedEmp = empdao.save(emp);
		return true;
		}
		
	@Override
	public boolean removeEmmployee(int eid) throws EmpNotFoundException {
		Emp emp= empdao.viewEmployee(eid);
		if(emp == null)
			throw new EmpNotFoundException("employee not found for the id"+eid);
		return empdao.removeEmployee(emp);
	}



	@Override
	public List<Emp> viewEmployee(LocalDate startDOJ, LocalDate endDOJ) throws EmpNotFoundException {
		List<Emp> lst = dao.viewEmployee(startDOJ,endDOJ);
		if(lst.isEmpty())
			throw new EmpNotFoundException("No Employee Found");
		lst.sort((e1,e2)->e1.getEmpDoj().compareTo(e2.getEmpDoj()));
		return lst;
	}



	

	*/
	

	@Override
	public List<Emp> viewEmployee(LocalDate startDOJ, LocalDate endDOJ) throws EmpNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editEmmployee(EmpDto empdto) throws DeptException, EmpNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEmmployee(int eid) throws EmpNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Dept> viewDepts() {
		// TODO Auto-generated method stub
		return null;
	}

}

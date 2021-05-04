package com.cg.service;

import java.util.List;
import java.util.Optional;

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
		// TODO Auto-generated method stub
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

}

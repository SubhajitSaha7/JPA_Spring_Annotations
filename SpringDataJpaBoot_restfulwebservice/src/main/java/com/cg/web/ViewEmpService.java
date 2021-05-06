package com.cg.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.EmpDto;
import com.cg.dto.ErrorMessage;
import com.cg.dto.SuccessMessage;
import com.cg.entity.Emp;
import com.cg.exceptions.DeptException;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.service.IEmpService;

@RestController
public class ViewEmpService {

	@Autowired
	private IEmpService service;
	
	
	//@RequestMapping(value = "viewbydept/{dname}", method=RequestMethod.GET)
	@GetMapping("viewbydept/{dname}")
	public List<Emp> viewEmployee(@PathVariable("dname") String dept) throws EmpNotFoundException {
		return service.viewEmployee(dept);
	}
	
	@GetMapping("viewbyid/{eid}")
	public Emp viewEmployeebyId(@PathVariable("eid") int empId) throws EmpNotFoundException {
		return service.viewEmployee(empId);
	}
	
	
	@GetMapping("viewallemployee")
	public List<Emp> viewAllEmployee() throws EmpNotFoundException {
		return service.viewEmployee();
	}
	
	@GetMapping("viewbydt/{sdoj}/{edoj}")
	public List<Emp> viewEmployeeByDate( @DateTimeFormat( pattern = "dd-MM-yyyy")@PathVariable("sdoj") LocalDate startdoj,  @DateTimeFormat( pattern = "dd-MM-yyyy") @PathVariable("edoj") LocalDate enddoj) throws EmpNotFoundException	{
		return service.viewEmployee(startdoj, enddoj);
		
	}
	
	
}

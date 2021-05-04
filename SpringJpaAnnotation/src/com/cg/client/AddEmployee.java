package com.cg.client;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.config.JpaConfiguration;
import com.cg.dto.EmpDto;
import com.cg.exceptions.DeptException;
import com.cg.service.IEmpService;

public class AddEmployee {

	static ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfiguration.class);

	public static void main(String[] args) {
		System.out.println("main starts");
		IEmpService ser = ctx.getBean("myservice", IEmpService.class);
		try {
			EmpDto empdto = new EmpDto("anand jain", 32000, LocalDate.of(2016, 9,21), "production" );
			Integer eid  = ser.addEmployee(empdto);
			System.out.println("Employee ADDED and ID is " +eid);
		} catch (DeptException e) {
			System.out.println(e.getMessage());
		}
		
	}
}

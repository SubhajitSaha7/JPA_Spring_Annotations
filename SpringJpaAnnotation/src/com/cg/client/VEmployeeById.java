package com.cg.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.config.JpaConfiguration;
import com.cg.entity.Emp;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.service.IEmpService;

public class VEmployeeById {
	static ApplicationContext ctx=new AnnotationConfigApplicationContext(JpaConfiguration.class);
	public static void main(String[] args) {
		IEmpService ser=ctx.getBean("myservice",IEmpService.class);
		try {
			Emp emp=ser.viewEmployee(1);
			System.out.println(emp+" "+emp.getDept().getDeptName());
		}catch(EmpNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

}

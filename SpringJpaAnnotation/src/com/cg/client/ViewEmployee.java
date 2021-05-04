package com.cg.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.config.JpaConfiguration;
import com.cg.entity.Emp;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.service.IEmpService;

public class ViewEmployee {
	
	static ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfiguration.class);

	public static void main(String[] args) {
		System.out.println("main starts");
		IEmpService ser = ctx.getBean("myservice", IEmpService.class);
		try {
			List<Emp> lst = ser.viewEmployee();
			lst.forEach(e->System.out.println(e.getEmpId() + " " + e.getEmpName() + " " 
							+ e.getEmpSal() + " " + e.getEmpDoj()+ " "+e.getDept().getDeptName()));
		} catch (EmpNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

}

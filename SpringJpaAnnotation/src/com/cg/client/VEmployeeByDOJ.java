package com.cg.client;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;

import com.cg.config.JpaConfiguration;
import com.cg.entity.Emp;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.service.IEmpService;

public class VEmployeeByDOJ {
	static ApplicationContext ctx=new AnnotationConfigApplicationContext(JpaConfiguration.class);
	public static void main(String[] args) {
		System.out.println("main starts");
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter the start date");
		String startstr=scan.next();
		System.out.println("Enter the end date");
		String endstr=scan.next();
		IEmpService ser=ctx.getBean("myservice",IEmpService.class);
		try {
			DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-M-d");
			LocalDate startDoj=LocalDate.parse(startstr,df);
			LocalDate endDoj=LocalDate.parse(endstr,df);
			List<Emp> lst = ser.viewEmployee(startDoj,endDoj);
			lst.forEach(e->System.out.println(e.getEmpId() + " " + e.getEmpName() + " " 
							+ e.getEmpSal() + " " + e.getEmpDoj()+ " "+e.getDept().getDeptName()));
		} catch (EmpNotFoundException | DateTimeException e) {
			System.out.println(e.getMessage());
		}
			scan.close();
		}
	}



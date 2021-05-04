package com.cg.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.service.IService;

public class ClientA {

	static ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	
	public static void main(String[] args) {
		System.out.println("main satrts");
		IService ser = ctx.getBean("myser", IService.class);
		System.out.println(ser.viewEmployee()); 
		System.out.println("demand second time");
		IService ser2 = ctx.getBean("myser", IService.class);
		System.out.println(ser2.viewEmployee()); 
	}

}

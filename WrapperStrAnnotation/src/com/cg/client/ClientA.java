package com.cg.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.service.ICurrencyService;

public class ClientA {
	
	static ApplicationContext ctx= new AnnotationConfigApplicationContext(MyConfig.class);
	
	public static void main(String[] args) {
		
		System.out.println("main starts");
		ICurrencyService ser= ctx.getBean("myser",ICurrencyService.class);
		System.out.println(ser.convertToINR(100));
		System.out.println(ser.currentState());
	}

}

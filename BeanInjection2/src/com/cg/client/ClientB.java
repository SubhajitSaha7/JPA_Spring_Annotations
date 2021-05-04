package com.cg.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.cg.service.IService;

@SuppressWarnings("deprecation")
public class ClientB {

	static BeanFactory fac = null;
	
	static {
		Resource res = new ClassPathResource("beans.xml");
		fac = new XmlBeanFactory(res);
	}
	public static void main(String[] args) {
		System.out.println("main satrts");
		IService ser = fac.getBean("myser", IService.class);
		System.out.println(ser.viewEmployee());
		System.out.println("demand second time");
		IService ser2 = fac.getBean("myser", IService.class);
		System.out.println(ser2.viewEmployee());
	}

}

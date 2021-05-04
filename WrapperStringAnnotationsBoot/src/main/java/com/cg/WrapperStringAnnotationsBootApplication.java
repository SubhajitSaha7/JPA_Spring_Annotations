package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.service.ICurrencyService;

@SpringBootApplication
public class WrapperStringAnnotationsBootApplication implements CommandLineRunner{

	@Autowired
	private ICurrencyService service;
	public static void main(String[] args) {
		SpringApplication.run(WrapperStringAnnotationsBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("main starts");
		System.out.println(service.convertToINR(100));
		System.out.println(service.currentState());
	}

}

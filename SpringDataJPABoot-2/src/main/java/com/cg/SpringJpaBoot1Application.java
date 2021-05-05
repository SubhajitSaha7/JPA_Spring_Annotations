package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.dto.AccountDto;
import com.cg.service.IAccountService;

@SpringBootApplication
public class SpringJpaBoot1Application implements CommandLineRunner{

	@Autowired
	private IAccountService accservice;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaBoot1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*	AccountDto account1 = new AccountDto("ram kumar", 50000.0);
		Integer res1 = accservice.addAccount(account1);
		System.out.println(res1 + "Account created ");
		AccountDto account2 = new AccountDto("ramesh kumar", 60000.0);
		Integer res2 = accservice.addAccount(account2);
		System.out.println(res2 + " Account created");*/
		System.out.println(accservice.getAccount(100));
		System.out.println(accservice.getAccount(101));
		System.out.println("After Transferring");
		boolean res = accservice.transferFund(100, 101, 15000.0);
		System.out.println(res);
		System.out.println(accservice.getAccount(100));
		System.out.println(accservice.getAccount(101));
		
		
	}

}

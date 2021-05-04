package com.cg;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.dto.EmpDto;
import com.cg.entity.Emp;
import com.cg.service.IEmpService;

@SpringBootApplication
public class SpringDataJpaBootApplication implements CommandLineRunner {
	@Autowired
	private IEmpService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("view all employee --------------------------------------------");
		service.viewEmployee().forEach(e -> System.out.println(e+" "+e.getDept()));
		System.out.println("view employee by id ------------------------------------------");
		Emp emp = service.viewEmployee(1953);
		System.out.println(emp);
//		EmpDto empdto =new EmpDto("ashish",78000.00,LocalDate.of(2017, 8, 19),"hr");
//		int eid = service.addEmployee(empdto);
//		System.out.println(eid);
		System.out.println("viewEmployee by department name");
		service.viewEmployee("hr").forEach(e -> System.out.println(e+" "+e.getDept()));
		
	}

}

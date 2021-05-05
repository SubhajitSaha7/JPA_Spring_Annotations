package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.dto.Emp;

@Controller
public class SalController {

	@GetMapping("salform")
	public String displaySalFormPage() {
		return "SalFormPage";
	}
	
	@PostMapping("calcsal")
	//@RequestMapping(value="processsal", method = RequestMethod.POST)
	public String processSalary(@ModelAttribute("emodel") Emp emp, Model model) {
		double pf = emp.getSal() * 0.12;
		double da = emp.getSal() * 0.35;
		double netsalary = emp.getSal() + da -pf;
		model.addAttribute("pf", pf);
		model.addAttribute("allowances", da);
		model.addAttribute("netsal", netsalary);
		return "SalSubmitPage";
	}
}











package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class EmiController {

	@RequestMapping("/emiform")
	public String displayEmiFormPage() {
		return "EmiformPage";
	}
	
	@RequestMapping("/emisubmit")
	public String processEmi(@RequestParam("txtamt") double amt, @RequestParam("txtyears") int years, Model model) {
		double compValue = amt * Math.pow((1+0.1), years);
		compValue = Math.round(compValue * 100)/100.0;
		double emi = compValue / (years * 12);
		emi = Math.round(emi*100)/100.0;
		model.addAttribute("totalamt", compValue);
		model.addAttribute("monthlyamt", emi);
		return "EmiSubmitPage";
	}
}

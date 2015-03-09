package com.magicclothing.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.magicclothing.domain.Customer;
import com.magicclothing.service.CustomerService;

@Controller
@SessionAttributes(value={"email", "valid"})
public class LoginController {
	
	@Autowired
	CustomerService customerService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String displayLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/customerOrder", method = RequestMethod.POST)
	public String loginIntoSystem(Customer loginCustomer, Model model, HttpServletRequest request) {
		
		Customer customer = customerService.findBy(loginCustomer.getEmail());
		
		
		if(customer == null || !customer.getPassword().equals(loginCustomer.getPassword())) {
				
			throw new RuntimeException("Username or Password is invalid");
		} 
				
		
		model.addAttribute("valid", true);
		model.addAttribute("email", customer.getEmail());
		
		return "customerOrder";
	}
	
}


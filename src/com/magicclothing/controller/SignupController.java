package com.magicclothing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.magicclothing.domain.Customer;

@Controller
public class SignupController {
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String displaySignup(@ModelAttribute("newCustomer") Customer customer) {
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String getSignup(@ModelAttribute Customer customer) {
		return "signup";
	}

}

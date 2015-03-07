package com.magicclothing.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.magicclothing.domain.Customer;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String displaySignup(@ModelAttribute("loginCustomer") Customer customer) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getSignup(@Valid @ModelAttribute("loginCustomer") Customer customer, BindingResult bindingResult,
			Model model) {
		
		if (bindingResult.hasErrors()) {
			return "login";
		}
		
		 String[] suppressedFields = bindingResult.getSuppressedFields();
		 if (suppressedFields.length > 0) {
		 throw new RuntimeException("You've attempted to bind fields that haven't been allowed in initBinder(): "
		 + StringUtils.addStringToArray(suppressedFields, ", "));
		 }
		
		
		// Customer log in
		
	    model.addAttribute("customer", customer);
	    
		return "login";
	}

}


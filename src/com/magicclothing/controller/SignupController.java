package com.magicclothing.controller;

import javax.validation.Valid;

import org.springframework.validation.FieldError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.magicclothing.domain.Customer;
import com.magicclothing.service.CustomerService;

@Controller("/customer")
public class SignupController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/displaysignup", method = RequestMethod.GET)
	public String displaySignup( @ModelAttribute("newCustomer") Customer customer) {
		return "signup";
	}
	
	@RequestMapping(value = "/signup")
	public String getSignup(@Valid @ModelAttribute("newCustomer") Customer customer, BindingResult bindingResult,
			Model model) {
		
		if (bindingResult.hasErrors()) {
//			System.out.println("this is the if");
//			System.out.println(bindingResult.getFieldErrors().toString());
			return "signup";
		}
		
		 String[] suppressedFields = bindingResult.getSuppressedFields();
		 if (suppressedFields.length > 0) {
		 throw new RuntimeException("You've attempted to bind fields that haven't been allowed in initBinder(): "
		 + StringUtils.addStringToArray(suppressedFields, ", "));
		 }
		
		// create customer
		customerService.save(customer);
		for(Customer customerList:customerService.getAll() ){
			System.out.println(customerList.getEmail());
		}
		
		
	    model.addAttribute("customer", customer);
		
		
		return "login";
	}

}

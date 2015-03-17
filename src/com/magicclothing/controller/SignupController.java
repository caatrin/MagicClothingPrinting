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
import com.magicclothing.service.PersonService;
import com.magicclothing.validator.PasswordValidator;

@Controller("/customer")
public class SignupController {

	@Autowired
	PersonService customerService;
	
	@Autowired
	private PasswordValidator passwordValidator;

	/**
	 * displays the view for signup
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/displaysignup", method = RequestMethod.GET)
	public String displaySignup(@ModelAttribute("newCustomer") Customer customer) throws Exception{
		return "signup";
	}

	/**
	 * creates a customer in the DB
	 * @param customer
	 * @param bindingResult
	 * @param model
	 * @return login.jsp
	 */
	@RequestMapping(value = "/signup")
	public String getSignup(@Valid @ModelAttribute("newCustomer") Customer customer, 
			BindingResult bindingResult, Model model) {
		
		PasswordValidator passwordValidator= new PasswordValidator();
		passwordValidator.validate(customer, bindingResult);
		if (bindingResult.hasErrors()) {
			return "signup";
		}

		String[] suppressedFields = bindingResult.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("You've attempted to bind fields that haven't been allowed in initBinder(): "
					+ StringUtils.addStringToArray(suppressedFields, ", "));
		}

		// create customer
//		if(!password.getPassword().equals(confirmPassword.getConfirmPassword())){
//			throw new RuntimeException("Password and Confirm Password are invalid");
//		}
		customerService.save(customer);
		model.addAttribute("customer", customer);
		return "login";
	}
}

package com.magicclothing.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.magicclothing.domain.Item;
import com.magicclothing.domain.ItemOrder;
import com.magicclothing.domain.Order;
import com.magicclothing.domain.Person;
import com.magicclothing.service.ItemService;
import com.magicclothing.service.OrderService;
import com.magicclothing.service.PersonService;
import com.magicclothing.validator.LoginValidator;
import com.magicclothing.validator.PasswordValidator;

@Controller
@SessionAttributes(value={"person", "valid"})
public class LoginController {
	
	@Autowired
	PersonService personService;
	
	@Autowired
	ItemService itemService;
	@Autowired
	OrderService orderService;
	@Autowired
	LoginValidator loginValidator;
	
	@RequestMapping(value = "/displaylogin", method = RequestMethod.GET)
	public String displayLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/customerOrder", method = RequestMethod.POST)
	public String loginIntoSystem(@ModelAttribute("loginCustomer") Person loginPerson, Model model, BindingResult bindingResult) throws Exception{
		
		Person person = personService.findBy(loginPerson.getEmail());
		
		loginValidator.validate(loginPerson, bindingResult);
		
		if(bindingResult.hasErrors()){
			return "login";
		}
//		if(person == null || !person.getPassword().equals(loginPerson.getPassword())) {		
//			throw new RuntimeException("Username or Password is invalid");
//		} 
		
		//admin login validation
		Person admin = personService.getAdmin();
//		System.out.println(person.getPersonId());
//		System.out.println(admin.getPersonId());
		if(person.getPersonId().equals(admin.getPersonId())){
			List<Order> listOfOrders = orderService.getAll();
			model.addAttribute("listOfOrders", listOfOrders);
			return "adminOrderHistory";
		}
				
		model.addAttribute("valid", true);
		model.addAttribute("person", person);
//		System.out.println("customer id: " + person.getPersonId());
		
		List<Item> listOfItems = itemService.getAll();
//		System.out.println("List of items: " + listOfItems.size());
		model.addAttribute("listOfItems", listOfItems);
		model.addAttribute("itemOrder", new ItemOrder());
		return "customerOrder";
	}
	
	
	 @RequestMapping ("/logout")
	  public String Logout(SessionStatus status ) throws Exception {
		  status.setComplete();
		  return  "redirect:displaylogin";  

	}
	
}


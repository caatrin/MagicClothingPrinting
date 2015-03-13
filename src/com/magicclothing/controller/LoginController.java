package com.magicclothing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.magicclothing.domain.Item;
import com.magicclothing.domain.ItemOrder;
import com.magicclothing.domain.Person;
import com.magicclothing.service.CustomerService;
import com.magicclothing.service.ItemService;

@Controller
@SessionAttributes(value={"person", "valid"})
public class LoginController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping(value = "/displaylogin", method = RequestMethod.GET)
	public String displayLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/customerOrder", method = RequestMethod.POST)
	public String loginIntoSystem(Person loginPerson, Model model) throws Exception{
		
		Person person = customerService.findBy(loginPerson.getEmail());
		
		if(person == null || !person.getPassword().equals(loginPerson.getPassword())) {		
			throw new RuntimeException("Username or Password is invalid");
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
	
}


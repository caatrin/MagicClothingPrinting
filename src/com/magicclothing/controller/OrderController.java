package com.magicclothing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {
	
	
	@RequestMapping(value = "/customerOrder", method = RequestMethod.GET)
	public String getCustomerOrder() {
		return "customerOrder";
	}
	
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public String addItem() {
		return "redirect:/customerOrder";
	}
	

}

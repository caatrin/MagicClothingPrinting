package com.magicclothing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	int i = 1;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String displayLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/customerOrder", method = RequestMethod.POST)
	public String loginIntoSystem(Model model) {	
		return "customerOrder";
	}

}


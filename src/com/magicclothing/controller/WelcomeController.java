package com.magicclothing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.magicclothing.domain.Customer;

@Controller
public class WelcomeController {
	
	/**
	 * displays the indew view
	 * @return index.jsp
	 */
	@RequestMapping({"/","/welcome"})
	public String getWelcomePage() {
		return "index";
	}

	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public String displayAboutUs() throws Exception{
		return "aboutUs";
	}
}

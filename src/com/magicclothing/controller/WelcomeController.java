package com.magicclothing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}

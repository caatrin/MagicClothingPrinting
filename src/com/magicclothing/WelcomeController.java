package com.magicclothing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping({"/","/welcome"})
	public String getWelcomePage() {
		return "index";
	}

}

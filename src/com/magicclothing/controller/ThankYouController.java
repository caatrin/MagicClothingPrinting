package com.magicclothing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThankYouController {
	

	@RequestMapping(value = "/thankyou", method = RequestMethod.POST)
	public String addItems() {
		return "redirect:/thankyou";
	}
	
	/**
	 * displays the thank you view
	 * @return thankyou.jsp
	 */
	@RequestMapping(value = "/thankyou", method = RequestMethod.GET)
	public String displayStatus() {
		return "thankyou";
	}
	
	

}

package com.magicclothing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FeedbackController {
	
	@RequestMapping(value="/feedback", method = RequestMethod.GET)
	public String getFeedbackPage() {
		return "feedback";
	}

}

package com.magicclothing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.magicclothing.domain.Feedback;


@Controller
public class FeedbackController {
	
	@RequestMapping(value="/feedback", method = RequestMethod.GET)
	public String getFeedbackPage(@ModelAttribute("newFeedback") Feedback feedback) {
		return "feedback";
	}

}

package com.magicclothing.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.magicclothing.domain.Feedback;


@Controller
public class FeedbackController {
	
	/**
	 * Display the feedback view
	 * @param feedback
	 * @return feedback.jsp
	 */

	@RequestMapping(value="/feedback", method = RequestMethod.GET)
	public String getFeedbackPage(@ModelAttribute("newFeedback") Feedback feedback) {
		return "feedback";
	}
	
	/**
	 * Save the feedback gave it from the customer
	 * @param feedback
	 * @param bindingResult
	 * @param model
	 * @return customerOrderHistory.jsp
	 */

	@RequestMapping(value="/giveFeedback", method = RequestMethod.POST)
	public String saveFeedback(@Valid @ModelAttribute("newFeedback") Feedback feedback,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "feedback";
		}

		String[] suppressedFields = bindingResult.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("You've attempted to bind fields that haven't been allowed in initBinder(): "
					+ StringUtils.addStringToArray(suppressedFields, ", "));
		}


		// save feedback into the DB

		model.addAttribute("feedback", feedback);

		return "customerOrderHistory";
	}

}

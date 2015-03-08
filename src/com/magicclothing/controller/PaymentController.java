package com.magicclothing.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.magicclothing.domain.PaymentInfo;

@Controller
public class PaymentController {
	
	@RequestMapping(value = "/displayPayment", method = RequestMethod.GET)
	public String displayPayment( @ModelAttribute("newPayment") PaymentInfo paymentInfo) {
		return "payment";
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String getPayment(@Valid @ModelAttribute("newPayment") PaymentInfo paymentInfo, BindingResult bindingResult,
			Model model) {
		
		if (bindingResult.hasErrors()) {
			return "payment";
		}
		
		 String[] suppressedFields = bindingResult.getSuppressedFields();
		 if (suppressedFields.length > 0) {
		 throw new RuntimeException("You've attempted to bind fields that haven't been allowed in initBinder(): "
		 + StringUtils.addStringToArray(suppressedFields, ", "));
		 }
		
		
		// Save payment
		
	    model.addAttribute("paymentInfo", paymentInfo);
		
		
		return "index";
	}

}

package com.magicclothing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerOrderHistoryController {
		
		@RequestMapping(value = "/displayCustomerOrder", method = RequestMethod.GET)
		public String displayCustomerOrderHistory() {
			return "customerOrderHistory";
		}

}

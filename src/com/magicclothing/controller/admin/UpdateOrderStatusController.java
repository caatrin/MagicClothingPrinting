package com.magicclothing.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.magicclothing.OrderStatus;

@Controller
public class UpdateOrderStatusController {

	@RequestMapping(value = "/updateOrderStatus",  method = RequestMethod.GET)
	public String displayUpdateOrderStatusPage() {
		
		return "updateOrderStatus";
	}
	
	
	
}

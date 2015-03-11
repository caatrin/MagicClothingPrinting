package com.magicclothing.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.magicclothing.domain.Item;
import com.magicclothing.domain.ItemOrder;
import com.magicclothing.service.ItemOrderService;
import com.magicclothing.service.ItemService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemOrderService itemOrderService;
	
	
	@RequestMapping(value = "/customerOrder", method = RequestMethod.GET)
	public String getCustomerOrder() {
		return "customerOrder";
	}
	
	@RequestMapping(value = "/addItemOrder", method = RequestMethod.POST)
	public String addItemOrder(ItemOrder itemOrder, Model model) {
		System.out.println("I am in add order");
		itemOrder.setTotalPrice(itemOrder.getUnits() * itemOrder.getItem().getPrice());
		itemOrderService.save(itemOrder);
		model.addAttribute("listOfItemOrders", itemOrderService.getAll());
		return "redirect:/customerOrder";
	}
	
	@RequestMapping(value = "/getItem" ,method = RequestMethod.GET)
	public @ResponseBody Item getItem(){
		return itemService.findBy("Pants");
	}
	
	
	

}

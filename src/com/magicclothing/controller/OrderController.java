package com.magicclothing.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.magicclothing.domain.Item;
import com.magicclothing.domain.ItemOrder;

@Controller
public class OrderController {
	
	private List<ItemOrder> listOfItemsOrder = new ArrayList();
	
	@RequestMapping(value = "/customerOrder", method = RequestMethod.GET)
	public String getCustomerOrder() {
		return "customerOrder";
	}
	
	@RequestMapping(value = "/addItemOrder", method = RequestMethod.POST)
	public String addItemOrder(ItemOrder itemOrder, Model model) {
		
		
		itemOrder.setTotalPrice(itemOrder.getUnits() * itemOrder.getItem().getPrice());
		
		listOfItemsOrder.add(itemOrder);
		
		
		model.addAttribute("listOfItemOrders", listOfItemsOrder);
		
		return "redirect:/customerOrder";
	}
	
	
	public @ResponseBody Item getItem(@RequestParam String name){
		//TODO: implement Item Service to get the item by name
		return null;
	}
	

}

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
import com.magicclothing.service.ItemService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	ItemService itemService;
	
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
	
	@RequestMapping(value = "/getItem" ,method = RequestMethod.POST)
	public @ResponseBody Item getItem(@RequestParam String name){
		return itemService.findBy(name);
	}
	
	
	

}

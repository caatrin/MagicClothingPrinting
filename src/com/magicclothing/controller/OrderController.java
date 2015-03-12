package com.magicclothing.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.magicclothing.domain.Customer;
import com.magicclothing.domain.Item;
import com.magicclothing.domain.ItemOrder;
import com.magicclothing.domain.Order;
import com.magicclothing.domain.Person;
import com.magicclothing.service.ItemOrderService;
import com.magicclothing.service.ItemService;
import com.magicclothing.service.OrderService;

@Controller
@SessionAttributes(value={"person", "valid"})
public class OrderController {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemOrderService itemOrderService;
	@Autowired
	OrderService orderService;
	
	private List<ItemOrder> listOfItemOrders = new ArrayList<ItemOrder>(); 
	
	@RequestMapping(value = "/customerOrder", method = RequestMethod.GET)
	public String getCustomerOrder(Model model) {
		List<Item> listOfItems = itemService.getAll();
		model.addAttribute("listOfItems", listOfItems);
		model.addAttribute("itemOrder", new ItemOrder());
		model.addAttribute("listOfItemOrders", listOfItemOrders);
		return "customerOrder";
	}
	
	@RequestMapping(value = "/addItemOrder", method = RequestMethod.POST)
	public String addItemOrder(@ModelAttribute ItemOrder itemOrder, Model model) {
		itemOrder.setTotalPrice(itemOrder.getUnits() * itemOrder.getItem().getPrice());
		Item item = itemService.findBy(itemOrder.getItem().getName());
		itemOrder.setItem(item);
		listOfItemOrders.add(itemOrder);
		return "redirect:/customerOrder";
	}
	
	@RequestMapping(value="/saveOrder", method = RequestMethod.POST)
	public String saveOrder(Model model) {
		String email = ((Person) model.asMap().get("person")).getEmail();
		Order order = new Order();
		order.setListOfItemOrders(listOfItemOrders);
		Customer customer = new Customer();
		customer.setEmail(email);
		order.setCustomer(customer);
		order.setStatus("On hold");
		order.setDate(new Date());
		orderService.save(order);
		return "redirect:/displayPayment";
	}
	
	
	/**
	 * Respond to ajax call and return a json with item object
	 * @param name
	 * @return Item
	 */
	@RequestMapping(value = "/getItem" ,method = RequestMethod.GET)
	public @ResponseBody Item getItem(@RequestParam String name){
		return itemService.findBy(name);
	}
	
	@RequestMapping(value = "/customerOrderHistory", method = RequestMethod.GET)
	public String displayCustomerOrderHistory(Model model) {
		Long personId = ((Person)model.asMap().get("person")).getPersonId();
		List<Order> personOrders = orderService.getAll(personId);
			System.out.println(personOrders.size());
		model.addAttribute("personOrders", personOrders);
		return "customerOrderHistory";
	}
	
	
	

}

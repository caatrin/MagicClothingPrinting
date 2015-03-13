package com.magicclothing.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.magicclothing.OrderStatus;
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
	
	private Date timeStamp = new Date();
	
	@RequestMapping(value = "/customerOrder", method = RequestMethod.GET)
	public String getCustomerOrder(Model model) {
		List<Item> listOfItems = itemService.getAll();
		model.addAttribute("listOfItems", listOfItems);
		model.addAttribute("itemOrder", new ItemOrder());
		model.addAttribute("listOfItemOrders", listOfItemOrders);
		return "customerOrder";
	}
	
	@RequestMapping(value = "/addItemOrder", method = RequestMethod.POST)
	public String addItemOrder(@ModelAttribute ItemOrder itemOrder, Model model, HttpServletRequest request) {
		itemOrder.setTotalPrice(itemOrder.getUnits() * itemOrder.getItem().getPrice());
		Item item = itemService.findBy(itemOrder.getItem().getName());
		itemOrder.setItem(item);
		
		//upload image
//		MultipartFile image = itemOrder.getImage();
//		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//		
//		if(image!=null && !image.isEmpty()){
//			try{
//				image.transferTo(new File(rootDirectory+"\\resources\\img\\"+itemOrder.getItemOrderId()));
//			}catch(Exception e){
//				throw new RuntimeException("Image save failed", e);
//			}
//		}
		
		//add item to list of item orders
		listOfItemOrders.add(itemOrder);
		return "redirect:/customerOrder";
	}
	
	@RequestMapping(value="/saveOrder", method = RequestMethod.POST)
	public String saveOrder(Model model) {
		setAndSaveOrder(model);
		return "redirect:/displayPayment";
	}
	
	@RequestMapping(value="/proceedPayment", method = RequestMethod.GET)
	public String proceedPayment(Model model, RedirectAttributes redirectAttributes ) {
		Order orderSaved = setAndSaveOrder(model);
		Double orderTotal = 0.0;
		List<ItemOrder> itemsFromOrder = orderSaved.getListOfItemOrders();
		for(int i= 0; i< itemsFromOrder.size();i++){
			orderTotal += listOfItemOrders.get(i).getTotalPrice();
		}
		orderSaved.setOrderTotal(orderTotal);
		redirectAttributes.addFlashAttribute("orderSaved", orderSaved);
//		redirectAttributes.addFlashAttribute("orderTotal", orderTotal);
//		System.out.println("Order Id "+orderSaved.getOrderId());
//		model.addAttribute("order", orderSaved);
//		model.addAttribute("orderTotal", orderTotal);
		return "redirect:/displayPayment";
	}
	
	private Order setAndSaveOrder(Model model){
		String email = ((Person) model.asMap().get("person")).getEmail();
		Order order = new Order();
		order.setListOfItemOrders(listOfItemOrders);
		Customer customer = new Customer();
		customer.setEmail(email);
		order.setCustomer(customer);
		order.setStatus(OrderStatus.PENDING.getLabel());
		order.setDate(timeStamp);
		orderService.save(order);
		return order;
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
//			System.out.println(personOrders.size());
		model.addAttribute("personOrders", personOrders);
		return "customerOrderHistory";
	}
	
	

}

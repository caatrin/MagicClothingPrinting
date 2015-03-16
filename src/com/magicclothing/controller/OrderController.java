package com.magicclothing.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
		initItemOrder(model);
		model.addAttribute("listOfItemOrders", listOfItemOrders);
		return "customerOrder";
	}
	@RequestMapping(value = "/createCustomerOrder", method = RequestMethod.GET)
	public String createCustomerOrder(Model model){
		initItemOrder(model);
		return "customerOrder";
	}
	
	private void initItemOrder(Model model) {
		List<Item> listOfItems = itemService.getAll();
		model.addAttribute("listOfItems", listOfItems);
		model.addAttribute("itemOrder", new ItemOrder());
	}
	
	@RequestMapping(value = "/addItemOrder", method = RequestMethod.POST)
	public String addItemOrder(@ModelAttribute ItemOrder itemOrder, Model model, HttpServletRequest request) {
		itemOrder.setTotalPrice(itemOrder.getUnits() * itemOrder.getItem().getPrice());
		Item item = itemService.findBy(itemOrder.getItem().getName());
		itemOrder.setItem(item);
		
		//upload image
		MultipartFile image = itemOrder.getImageFile();
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		System.out.println("root directory is " + rootDirectory);
		if(image!=null && !image.isEmpty()){
			System.out.println("hello from if");
			try{
				DateFormat date = new SimpleDateFormat("MM_dd_YY_hhmm");
				image.transferTo(new File(rootDirectory+"\\resources\\img\\customerImg\\" + 
						itemOrder.getItem().getName() + "_" + date.format(timeStamp) + ".png"));
				itemOrder.setImage(image.getOriginalFilename());
			}catch(Exception e){
				throw new RuntimeException("Image save failed", e);
			}
		}
		
		//add item to list of item orders
		listOfItemOrders.add(itemOrder);
		return "redirect:/customerOrder";
	}
	
	@RequestMapping(value="/saveOrder", method = RequestMethod.POST)
	public String saveOrder(Model model) {
		setAndSaveOrder(model);
		return "redirect:/customerOrderHistory";
	}
	
	@RequestMapping(value="/proceedPayment", method = RequestMethod.GET)
	public String proceedPayment(Model model, RedirectAttributes redirectAttributes ) {
		Order orderSaved = setAndSaveOrder(model);
		Double orderTotal = 0.0;
		List<ItemOrder> itemsFromOrder = orderSaved.getListOfItemOrders();
		for(int i= 0; i< itemsFromOrder.size();i++){
			orderTotal += orderSaved.getListOfItemOrders().get(i).getTotalPrice();
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
		listOfItemOrders = new ArrayList<ItemOrder>();
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
		for(Order order : personOrders) {
			Double orderTotal = 0.0;
			for (ItemOrder io : order.getListOfItemOrders()) {
				orderTotal += io.getTotalPrice();
				order.setOrderTotal(orderTotal);
			}
		}
		
//			System.out.println(personOrders.size());
		model.addAttribute("personOrders", personOrders);
		return "customerOrderHistory";
	}
	
	@RequestMapping(value = "/adminOrderHistory", method = RequestMethod.GET)
	public String displayAdminOrderHistory(Model model) {
		List<Order> listOfOrders = orderService.getAll();
		model.addAttribute("listOfOrders", listOfOrders);
		return "adminOrderHistory";
	}
	
	@RequestMapping(value = "/updateOrderStatus", method = RequestMethod.GET)
	public String displayUpdateOrderStatus(@RequestParam Long orderId, Model model) {
		Order order = orderService.get(orderId);
		model.addAttribute("order", order);
		model.addAttribute("listOfStatuses", OrderStatus.values());
		return "updateOrderStatus";
	}
	
	@RequestMapping(value = "/orderId/{orderId}/changeStatus/{status}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void changeStatus(@PathVariable Long orderId, @PathVariable String status, Model model) {
		Order order = orderService.get(orderId);
		order.setStatus(status);
		orderService.save(order);
	}
	
	

}

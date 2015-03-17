package com.magicclothing.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.magicclothing.OrderStatus;
import com.magicclothing.domain.ItemOrder;
import com.magicclothing.domain.Order;
import com.magicclothing.domain.Payment;
import com.magicclothing.domain.Person;
import com.magicclothing.service.OrderService;
import com.magicclothing.service.PaymentService;

@Controller
@SessionAttributes(value={"person", "valid"})
public class PaymentController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	PaymentService paymentService;
	
	/**
	 * Displays the view for processing the payment
	 * @param paymentInfo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/displayPayment", method = RequestMethod.GET)
	public String displayPayment(@ModelAttribute("newPayment") Payment paymentInfo, Model model) {
		//Long id = ((Person) model.asMap().get("person")).getPersonId();
		//orderService.getAll(id);
		model.addAttribute("order", model.asMap().get("orderSaved"));
		
		return "payment";
	}
	
	@RequestMapping(value = "/payOrder", method = RequestMethod.GET)
	public String displaySavedOrderPayment(@ModelAttribute("newPayment") Payment paymentInfo, 
			@RequestParam Long orderId, Model model) {
		Order order = orderService.get(orderId);
		Double orderTotal = 0.0;
		List<ItemOrder> itemsFromOrder = order.getListOfItemOrders();
		for(int i= 0; i< itemsFromOrder.size();i++){
			orderTotal += order.getListOfItemOrders().get(i).getTotalPrice();
		}
		order.setOrderTotal(orderTotal);
		System.out.println("order total is: " + order.getOrderTotal());
		model.addAttribute("order", order);
		return "payment";
	}
	
	/**
	 * Change the status from Pending to Processing on an order after saving the payment in the db
	 * @param payment
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String getPayment(@Valid @ModelAttribute("newPayment") Payment payment, BindingResult bindingResult,
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
		payment.setTranssactionDate(new Date());
		Order order = orderService.get(payment.getOrder().getOrderId());
		payment.setOrder(order);
		payment.getOrder().setPayment(payment);
		payment.getOrder().setStatus(OrderStatus.PROCESSING.getLabel());
		orderService.save(payment.getOrder());
//		paymentService.save(payment);
//		System.out.println("da payment"+payment);
		
		return "thankyou";
	}

}

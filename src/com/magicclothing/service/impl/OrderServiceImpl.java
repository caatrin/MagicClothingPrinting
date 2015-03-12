package com.magicclothing.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.magicclothing.domain.Customer;
import com.magicclothing.domain.Order;
import com.magicclothing.repository.CustomerRepository;
import com.magicclothing.repository.OrderRepository;
import com.magicclothing.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	
	@Override
	public List<Order> getAll() {
		return orderRepository.getAllOrders();
	}

	@Override
	public Order get(Long id) {
		return orderRepository.findOne(id);
	}

	@Override
	public void save(Order order) {
		Customer customer = customerRepository.getCustomerByEmail(order.getCustomer().getEmail());
		order.setCustomer(customer);
		orderRepository.save(order);
	}

	@Override
	public List<Order> getAll(Long id) {
		return orderRepository.findAllOrders(id);
	}

	@Override
	public Order findOrderByDate(Long id, Date date) {
		return orderRepository.findOrderByDate(id, date);
	}

}

package com.magicclothing.service;

import java.util.List;

import com.magicclothing.domain.Order;

public interface OrderService {
	
	public List<Order> getAll();
	public List<Order> getAll(Long id);
	public Order get(Long id);
	public void save(Order order);

}

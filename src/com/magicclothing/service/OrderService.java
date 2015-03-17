package com.magicclothing.service;

import java.util.Date;
import java.util.List;

import com.magicclothing.domain.Order;

/**
 * Services to retrieve the information
 * of the orders from the DB
 * @author MVC Unicorns
 *
 */
public interface OrderService {
	
	public List<Order> getAll();
	public List<Order> getAll(Long id);
	public Order get(Long id);
	public Order findOrderByDate(Long id, Date date);
	public void save(Order order);

}

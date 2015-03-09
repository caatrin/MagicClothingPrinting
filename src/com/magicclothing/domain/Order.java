package com.magicclothing.domain;

import java.util.Date;
import java.util.List;

public class Order {
	
	private Long orderId;
	private List<ItemOrder> listOfItemOrders;
	private Customer customerId;
	private Date date;
	private String status;
	
	public Order() {
		
	}
	
	public Long getOrderId() {
		return orderId;
	
	}
	public List<ItemOrder> getListOfItemOrders() {
		return listOfItemOrders;
	}
	public void setListOfItemOrders(List<ItemOrder> listOfItemOrders) {
		this.listOfItemOrders = listOfItemOrders;
	}
	public Customer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
		
	

}

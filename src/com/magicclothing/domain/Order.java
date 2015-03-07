package com.magicclothing.domain;

import java.util.Date;
import java.util.List;

public class Order {
	
	private Long orderId;
	private List<Item> listItems;
	private Integer totalPrice;
	private Long paymentId;
	private Long customerId;
	private Integer itemUnits;
	private String itemImage;
	private Date date;
	
	
	public List<Item> getListItems() {
		return listItems;
	}
	public void setListItems(List<Item> listItems) {
		this.listItems = listItems;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Integer getItemUnits() {
		return itemUnits;
	}
	public void setItemUnits(Integer itemUnits) {
		this.itemUnits = itemUnits;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getOrderId() {
		return orderId;
	}
	
	

}

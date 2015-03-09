package com.magicclothing.domain;

public class Item {
	
	private Long itemId;
	private String name;
	private Double price;
	
	public Item() {
	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getItemId() {
		return itemId;
	}
	

}

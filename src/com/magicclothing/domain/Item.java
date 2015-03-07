package com.magicclothing.domain;

public class Item {
	
	private Long itemId;
	private String itemName;
	private Long pricePerUnit;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Long getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(Long pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public Long getItemId() {
		return itemId;
	}
	
	

}

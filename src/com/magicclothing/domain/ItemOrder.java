package com.magicclothing.domain;

public class ItemOrder {
	
	private Long itemOrderId;
	private Item item;
	private Integer units;
	private String image;
	private Double totalPrice;
	

	public ItemOrder() {
		
	}
	
	public Long getItemOrderId() {
		return itemOrderId;
	}

	public void setItemOrderId(Long itemOrderId) {
		this.itemOrderId = itemOrderId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	


}

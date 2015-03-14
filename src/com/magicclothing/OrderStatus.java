package com.magicclothing;

import java.util.List;

public enum OrderStatus {
	
	PENDING ("Pending"),
	PROCESSING ("Processing"),
	PICK_UP ("Pickup"),
	PRINTING ("Printing"),
	DELIVERY ("Delivery"),
	COMPLETED ("Completed");
	private String label;
	
	OrderStatus(String label){
		this.label=label;
	}
	
	public String getLabel(){
		return label;
	}
	
	
	
}

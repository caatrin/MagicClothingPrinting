package com.magicclothing.domain;


public class Feedback {

	
	private String orderId;
	private Integer rating;
	private String positive;
	private String negative;
	
	public Feedback() {
		
	}
	
	public Feedback(String orderId, Integer rating, String positive,
			String negative) {
		this.orderId = orderId;
		this.rating = rating;
		this.positive = positive;
		this.negative = negative;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getPositive() {
		return positive;
	}
	public void setPositive(String positive) {
		this.positive = positive;
	}
	public String getNegative() {
		return negative;
	}
	public void setNegative(String negative) {
		this.negative = negative;
	}
}
package com.magicclothing.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class PaymentInfo implements Serializable{
	
	private Integer paymentId;
	@NotNull
	private String paymentType;
	@NotNull
	private Long cardNumber;
	private Double transactionAmount;
	private Date transsactionDate;
	
//	private String orderId;
//	private Integer total;
	
	public PaymentInfo(){}
	
	public PaymentInfo(Integer paymentId, String paymentType,
			Long cardNumber, Double transactionAmount, Date transsactionDate) {
		
		this.paymentId = paymentId;
		this.paymentType = paymentType;
		this.cardNumber = cardNumber;
		this.transactionAmount = transactionAmount;
		this.transsactionDate = transsactionDate;
//		this.orderId = orderId;
//		this.total = total;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTranssactionDate() {
		return transsactionDate;
	}

	public void setTranssactionDate(Date transsactionDate) {
		this.transsactionDate = transsactionDate;
	}

//
//	public String getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(String orderId) {
//		this.orderId = orderId;
//	}
//
//	public Integer getTotal() {
//		return total;
//	}
//
//	public void setTotal(Integer total) {
//		this.total = total;
//	}
	
	
	

}

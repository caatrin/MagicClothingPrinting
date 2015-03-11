package com.magicclothing.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema="magicclothingprinting")
public class Payment implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long paymentId;
	@NotNull
	private String paymentType;
	@NotNull
	private Long cardNumber;
	private Double transactionAmount;
	@Temporal(TemporalType.TIMESTAMP)
	private Date transsactionDate;
	@OneToOne
	private Order order;
	
	public Payment(){
		
	}
	
	public Payment(Long paymentId, String paymentType,
			Long cardNumber, Double transactionAmount, Date transsactionDate) {
		
		this.paymentId = paymentId;
		this.paymentType = paymentType;
		this.cardNumber = cardNumber;
		this.transactionAmount = transactionAmount;
		this.transsactionDate = transsactionDate;
//		this.orderId = orderId;
//		this.total = total;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
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

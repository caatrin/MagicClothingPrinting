package com.magicclothing.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema="magicclothingprinting")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long orderId;
	@OneToMany(cascade = CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="orderId")
	private List<ItemOrder> listOfItemOrders;
	@OneToOne()
	private Customer customer;
	@Temporal(TemporalType.TIMESTAMP)
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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

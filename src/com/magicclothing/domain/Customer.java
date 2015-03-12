package com.magicclothing.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DiscriminatorValue("Customer")
public class Customer extends Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "{NotEmpty.person.street.validation}")
	private String street;
	private String city;
	private String state;
	@NotNull(message = "{NotNull.person.zipcode.validation}")
	private Integer zipcode;
	@NotNull(message = "{NotNull.person.phoneNumber.validation}")
	private Long phoneNumber;
	@NotEmpty(message = "{NotEmpty.person.confirmPassword.validation}")
	private String confirmPassword;
	@OneToMany(mappedBy="customer")
	private List<Order> listOfOrders;
	
	public Customer(){
		
	}
	
		public Customer(String street, String city, String state, Integer zipcode,
			Long phoneNumber, String confirmPassword) {
		
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.confirmPassword = confirmPassword;
		
	}
		
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public List<Order> getListOfOrders() {
		return listOfOrders;
	}
	public void setListOfOrder(List<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}
	

}

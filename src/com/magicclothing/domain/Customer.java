package com.magicclothing.domain;

import java.io.Serializable;

public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String email;
	private String street;
	private String city;
	private String state;
	private int zipcode;
	private int phoneNumber;
	private String password;
	private String confirmPassword;
	
	public Customer(){
		
	}
	
		public Customer(String firstName, String lastName, String email,
			String street, String city, String state, int zipcode,
			int phoneNumber, String password, String confirmPassword) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	

}

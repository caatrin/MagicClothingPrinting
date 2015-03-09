package com.magicclothing.service;

import java.util.List;

import com.magicclothing.domain.Customer;

public interface CustomerService {
	
	public List<Customer> getAll();
	public void save(Customer customer);
	public Customer findBy(String email);

}

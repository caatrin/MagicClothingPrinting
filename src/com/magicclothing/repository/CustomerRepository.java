package com.magicclothing.repository;

import java.util.List;

import com.magicclothing.domain.Customer;

public interface CustomerRepository {
	
	public List<Customer> getAll();
	public void save(Customer customer);

}

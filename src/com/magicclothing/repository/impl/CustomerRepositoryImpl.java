package com.magicclothing.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.magicclothing.domain.Customer;
import com.magicclothing.repository.CustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
	
	private List<Customer> listOfCustomers = new ArrayList<Customer>();

	@Override
	public List<Customer> getAll() {
		return listOfCustomers;
	}

	@Override
	public void save(Customer customer) {
		listOfCustomers.add(customer);
		
	}
	
	

}

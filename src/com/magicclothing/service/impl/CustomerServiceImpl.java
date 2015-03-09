package com.magicclothing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicclothing.domain.Customer;
import com.magicclothing.repository.CustomerRepository;
import com.magicclothing.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAll() {
		return customerRepository.getAll();
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public Customer findBy(String email) {
		
		List<Customer> listOfCustomer = customerRepository.getAll();
		for(Customer customer: listOfCustomer){
			if(customer.getEmail().equals(email)){
				return customer;
			}
		}
		
		return null;
	}

}

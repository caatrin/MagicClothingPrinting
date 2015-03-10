package com.magicclothing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.magicclothing.domain.Customer;
import com.magicclothing.repository.CustomerRepository;
import com.magicclothing.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAll() {
		return customerRepository.getAllCustomers();
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public Customer findBy(String email) {
		return customerRepository.getCustomerByEmail(email);
	}

	@Override
	public Customer get(Long id) {
		return customerRepository.findOne(id);
	}

}

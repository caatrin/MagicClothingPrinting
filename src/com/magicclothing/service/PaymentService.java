package com.magicclothing.service;

import java.util.List;

import com.magicclothing.domain.Payment;

/**
 * Service for retrieve the payment information
 * from the db
 * @author MVC Unicorns
 *
 */
public interface PaymentService {
	
	public List<Payment> getAll();
	public void save(Payment payment);
	public Payment get(Long id);

}

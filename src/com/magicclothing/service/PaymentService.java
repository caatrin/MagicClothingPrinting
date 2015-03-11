package com.magicclothing.service;

import java.util.List;

import com.magicclothing.domain.Payment;

public interface PaymentService {
	
	public List<Payment> getAll();
	public void save(Payment payment);
	public Payment get(Long id);

}

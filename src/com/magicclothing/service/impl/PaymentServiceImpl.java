package com.magicclothing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.magicclothing.domain.Payment;
import com.magicclothing.repository.PaymentRepository;
import com.magicclothing.service.PaymentService;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public List<Payment> getAll() {
		return paymentRepository.getAllPayments();
	}

	@Override
	public void save(Payment payment) {
		paymentRepository.save(payment);
	}

	@Override
	public Payment get(Long id) {
		return paymentRepository.findOne(id);
	}

}

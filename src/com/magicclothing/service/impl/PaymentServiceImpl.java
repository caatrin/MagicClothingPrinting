package com.magicclothing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.magicclothing.OrderStatus;
import com.magicclothing.domain.Order;
import com.magicclothing.domain.Payment;
import com.magicclothing.repository.OrderRepository;
import com.magicclothing.repository.PaymentRepository;
import com.magicclothing.service.PaymentService;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	OrderRepository orderRepository;
	@Override
	public List<Payment> getAll() {
		return paymentRepository.getAllPayments();
	}

	@Override
	public void save(Payment payment) {
		Order order = orderRepository.findOne(payment.getOrder().getOrderId());
		order.setStatus(OrderStatus.PROCESSING.getLabel());
		payment.setOrder(order);
		//orderRepository.save(order);
		paymentRepository.save(payment);
		
	}

	@Override
	public Payment get(Long id) {
		return paymentRepository.findOne(id);
	}

}

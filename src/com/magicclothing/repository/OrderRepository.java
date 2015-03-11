package com.magicclothing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.magicclothing.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
	
	@Query("SELECT o FROM Order o")
	public List<Order> getAllOrders();

}

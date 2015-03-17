package com.magicclothing.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.magicclothing.domain.Order;

/**
 * CRUD for all the customer by id and/or date 
 * @author MVC Unicorns
 *
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
	
	@Query("SELECT o FROM Order o")
	public List<Order> getAllOrders();
	
	@Query("SELECT o FROM Order o WHERE o.customer.personId = :id")
	public List<Order> findAllOrders(@Param("id")Long id);
	
	@Query("SELECT o FROM Order o WHERE o.customer.personId = :id AND date = :date")
	public Order findOrderByDate(@Param("id")Long id, @Param("date")Date date);
}

package com.magicclothing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.magicclothing.domain.Payment;

/**
 * CRUD for all the payments in the DB
 * @author MVC Unicorns
 *
 */
@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long>{
	
	@Query("SELECT p FROM Payment p")
	public List<Payment> getAllPayments();

}

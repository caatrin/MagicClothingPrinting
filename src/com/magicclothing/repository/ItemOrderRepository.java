package com.magicclothing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.magicclothing.domain.Item;
import com.magicclothing.domain.ItemOrder;

/**
 * 
 * @author MVC Unicorns
 *
 */
@Repository
public interface ItemOrderRepository extends CrudRepository<ItemOrder, Long>{
	
	@Query("SELECT io FROM ItemOrder io")
	public List<ItemOrder> getAllItemOrders();
	
	public ItemOrder getItemOrderByItem(Item item);
	
//	@Query("SELECT i FROM ItemOrder i WHERE i.orderid = :id")
//	public List<ItemOrder> getItemByOrderId(@Param("id")Long id);

}

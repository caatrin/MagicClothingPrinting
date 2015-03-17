package com.magicclothing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.magicclothing.domain.Item;

/**
 * CRUD for all the items created in the DB
 * @author MVC Unicorns
 *
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
	
	@Query("SELECT i FROM Item i")
	public List<Item> getAllItems();
	
	public Item getItemByName(String name);

}

package com.magicclothing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.magicclothing.domain.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
	
	public Item getItemByName(String name);

}

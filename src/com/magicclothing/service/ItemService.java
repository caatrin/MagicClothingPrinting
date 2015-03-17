package com.magicclothing.service;

import java.util.List;

import com.magicclothing.domain.Item;

/**
 * Service to retrieve the items/products
 * from the DB
 * @author MVC Unicorns
 *
 */
public interface ItemService {
	
	public Item findBy(String name);
	
	public List<Item> getAll();

}

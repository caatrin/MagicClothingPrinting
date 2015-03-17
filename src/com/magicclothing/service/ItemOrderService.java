package com.magicclothing.service;

import java.util.List;

import com.magicclothing.domain.Item;
import com.magicclothing.domain.ItemOrder;

/**
 * Service to retrieve all the items in a customer's
 * orde from the DB
 * @author MVC Unicorns
 *
 */
public interface ItemOrderService {
	
	public List<ItemOrder> getAll();
//	public List<ItemOrder> getItemByOrderId(Long id);
	public void save(ItemOrder itemOrder);
	public ItemOrder findBy(Item item);
	public ItemOrder get(Long id);
	

}

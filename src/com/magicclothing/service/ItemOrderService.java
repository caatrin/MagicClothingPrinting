package com.magicclothing.service;

import java.util.List;

import com.magicclothing.domain.Item;
import com.magicclothing.domain.ItemOrder;

public interface ItemOrderService {
	
	public List<ItemOrder> getAll();
	public void save(ItemOrder itemOrder);
	public ItemOrder findBy(Item item);
	public ItemOrder get(Long id);

}

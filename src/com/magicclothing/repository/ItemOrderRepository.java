package com.magicclothing.repository;

import java.util.List;

import com.magicclothing.domain.ItemOrder;

public interface ItemOrderRepository {
	
	public List<ItemOrder> getAll();
	public void save(ItemOrder itemOrder);

}

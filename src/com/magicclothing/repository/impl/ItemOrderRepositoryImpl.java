package com.magicclothing.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.magicclothing.domain.ItemOrder;
import com.magicclothing.repository.ItemOrderRepository;

@Repository
public class ItemOrderRepositoryImpl implements ItemOrderRepository {
	
	List<ItemOrder> listOfItemOrders = new ArrayList<ItemOrder>();

	@Override
	public List<ItemOrder> getAll() {
		return listOfItemOrders;
	}

	@Override
	public void save(ItemOrder itemOrder) {
		listOfItemOrders.add(itemOrder);

	}

}

package com.magicclothing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.magicclothing.domain.Item;
import com.magicclothing.domain.ItemOrder;
import com.magicclothing.repository.ItemOrderRepository;
import com.magicclothing.repository.ItemRepository;
import com.magicclothing.service.ItemOrderService;

/**
 * Implementation of each one of the services
 * @author MVC Unicorns
 *
 */
@Service
@Transactional
public class ItemOrderServiceImpl implements ItemOrderService {
	
	@Autowired
	ItemOrderRepository itemOrderRepository;
	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public List<ItemOrder> getAll() {
		return itemOrderRepository.getAllItemOrders();
	}

	@Override
	public void save(ItemOrder itemOrder) {
//		Item item = itemRepository.getItemByName(itemOrder.getItem().getName());
//		itemOrder.setItem(item);
		itemOrderRepository.save(itemOrder);
	}

	@Override
	public ItemOrder findBy(Item item) {
		return itemOrderRepository.getItemOrderByItem(item);
	}

	@Override
	public ItemOrder get(Long id) {
		return itemOrderRepository.findOne(id);
	}

//	@Override
//	public List<ItemOrder> getItemByOrderId(Long id) {
//		return itemOrderRepository.getItemByOrderId(id);
//	}

}

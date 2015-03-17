package com.magicclothing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.magicclothing.domain.Item;
import com.magicclothing.repository.ItemRepository;
import com.magicclothing.service.ItemService;

/**
 * Implementation of each one of the services
 * @author MVC Unicorns
 *
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public Item findBy(String name) {
		return itemRepository.getItemByName(name);
	}

	@Override
	public List<Item> getAll() {
		return itemRepository.getAllItems();
	}

}

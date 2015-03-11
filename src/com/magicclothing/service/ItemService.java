package com.magicclothing.service;

import java.util.List;

import com.magicclothing.domain.Item;

public interface ItemService {
	
	public Item findBy(String name);
	
	public List<Item> getAll();

}

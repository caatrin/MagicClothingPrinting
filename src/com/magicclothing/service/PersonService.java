package com.magicclothing.service;

import java.util.List;

import com.magicclothing.domain.Customer;
import com.magicclothing.domain.Person;

/**
 * Services for Customer and Admin to retrieve information
 * from the DB
 * @author MVC Unicorns
 *
 */
public interface PersonService {
	
	public List<Person> getAll();
	public void save(Person person);
	public Person findBy(String email);
	public Person get(Long id);
	public Person getAdmin();

}

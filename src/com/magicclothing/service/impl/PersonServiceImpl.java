package com.magicclothing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.magicclothing.domain.Customer;
import com.magicclothing.domain.Person;
import com.magicclothing.repository.PersonRepository;
import com.magicclothing.service.PersonService;

/**
 * Implementation of each one of the services
 * @author MVC Unicorns
 *
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public List<Person> getAll() {
		return personRepository.getAllPersons();
	}

	@Override
	public void save(Person person) {
		personRepository.save(person);
		
	}

	@Override
	public Person findBy(String email) {
		return personRepository.getPersonByEmail(email);
	}

	@Override
	public Person get(Long id) {
		return personRepository.findOne(id);
	}

	@Override
	public Person getAdmin() {
		return personRepository.getAdmin();
	}

}

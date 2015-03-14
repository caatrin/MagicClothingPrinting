package com.magicclothing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.magicclothing.domain.Customer;
import com.magicclothing.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	
	@Query("SELECT c FROM Person c")
	public List<Person> getAllPersons();
	@Query("SELECT c FROM Person c WHERE c.personType = 'Staff'")
	public Person getAdmin();
	public Person getPersonByEmail(String email);

}

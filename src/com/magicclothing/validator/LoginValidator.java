package com.magicclothing.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.magicclothing.domain.Person;
import com.magicclothing.service.PersonService;

/**
 * Password validation for the login form, is it valid or not the password or
 * email the user filled on the fields
 * @author MVC Unicorns
 *
 */
@Component
public class LoginValidator implements Validator{
	
	@Autowired
	PersonService personService;

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors ) {
		 Person person = (Person) target;
//		 System.out.println("person "+person.getEmail());
//		 System.out.println(personService != null);
		 Person loginPerson = personService.findBy(person.getEmail());
		 
		 if(person == null || !person.getPassword().equals(loginPerson.getPassword())){
			 errors.reject("password", "Email or password are invalid, please try again.");
		 }
		
	}

}

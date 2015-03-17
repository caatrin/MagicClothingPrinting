package com.magicclothing.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.magicclothing.domain.Customer;

/**
 * Validation of Password and ConfirmPassword fields to be the same
 * @author MVC Unicorns
 *
 */
@Component
public class PasswordValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer c = (Customer) target;
		
		if(!c.getConfirmPassword().equals(c.getPassword())){
			errors.rejectValue("confirmPassword","com.magicclothing.validator.PasswordValidator.message");
		}
			
		
	}

	




}

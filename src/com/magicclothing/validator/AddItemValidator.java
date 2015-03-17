package com.magicclothing.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.magicclothing.domain.ItemOrder;

/**
 * Validation for units when adding and item
 * @author MVC Unicorns
 *
 */
@Component
public class AddItemValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		 ItemOrder io = (ItemOrder) target;
		
		 if(io == null){
			errors.reject("addItem", "com.magicclothing.validator.AddItemValidator.message"); 
		 }
		
	}

}

package com.magicclothing.domain;

import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;

/**
 * Admin domain
 * @author MVC Unicorns
 *
 */

@Entity
@DiscriminatorValue("Staff")
public class Staff extends Person{
	
	public Staff(){
		super();		
	}

}

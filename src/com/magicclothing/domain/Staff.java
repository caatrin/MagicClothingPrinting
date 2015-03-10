package com.magicclothing.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Staff")
public class Staff extends Person{
	
	public Staff(){
		super();		
	}

}

package com.magicclothing.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Inheritance()
@DiscriminatorColumn(name="personType")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long personId;
	@NotEmpty(message = "{NotEmpty.person.firstName.validation}")
	private String firstName;
	@NotEmpty(message = "{NotEmpty.person.lastName.validation}")
	private String lastName;
	@NotEmpty(message = "{NotEmpty.person.email.validation}")
	private String email;
	@NotEmpty(message = "{NotEmpty.person.password.validation}")
	private String password;
	@Column(insertable=false, updatable=false)
	private String personType;
	
	public Person() {
		
	}
	
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

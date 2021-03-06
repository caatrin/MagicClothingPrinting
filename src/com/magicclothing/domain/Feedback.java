package com.magicclothing.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Feedback domain
 * @author MVC Unicorns
 *
 */
@Entity
@Table(schema="magicclothingprinting")
public class Feedback {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long feedbackId;
	@OneToOne
	private Order order;
	@NotNull
	private Integer rating;
	@NotEmpty
	private String positive;
	@NotEmpty
	private String negative;
	
	public Feedback() {
		
	}
	
	public Feedback(Order order, Integer rating, String positive,
			String negative) {
		this.order = order;
		this.rating = rating;
		this.positive = positive;
		this.negative = negative;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getPositive() {
		return positive;
	}
	public void setPositive(String positive) {
		this.positive = positive;
	}
	public String getNegative() {
		return negative;
	}
	public void setNegative(String negative) {
		this.negative = negative;
	}
}

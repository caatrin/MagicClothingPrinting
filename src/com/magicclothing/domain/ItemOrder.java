package com.magicclothing.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

/**
 * List of items from a customer order
 * @author MVC Unicorns
 *
 */
@Entity
@Table(schema="magicclothingprinting")
public class ItemOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long itemOrderId;
	@OneToOne(cascade = CascadeType.MERGE)
	private Item item;
	private Integer units;
//	private MultipartFile image;
	private String image;
	private Double totalPrice;
	

	public ItemOrder() {
		
	}
	
	public Long getItemOrderId() {
		return itemOrderId;
	}

	public void setItemOrderId(Long itemOrderId) {
		this.itemOrderId = itemOrderId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	


}

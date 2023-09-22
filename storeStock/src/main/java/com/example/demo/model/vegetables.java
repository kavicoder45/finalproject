package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class vegetables {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String vegetableName;
	private float Quantity;
	private float price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVegetableName() {
		return vegetableName;
	}
	public void setVegetableName(String vegetableName) {
		this.vegetableName = vegetableName;
	}
	public float getQuantity() {
		return Quantity;
	}
	public void setQuantity(float quantity) {
		Quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public vegetables(Integer id, String vegetableName, float quantity, float price) {
		super();
		this.id = id;
		this.vegetableName = vegetableName;
		Quantity = quantity;
		this.price = price;
	}
	public vegetables() {
		super();
	}
	
	

}

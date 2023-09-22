package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vegetable {

	
	@Id
	private Integer vegId;
	private String vegName;
	private float price;
	
	
	public Vegetable(Integer vegId, String vegName, float price) {
		super();
		this.vegId = vegId;
		this.vegName = vegName;
		this.price = price;
	}
	
	public Vegetable() {
		super();
	}

	public Integer getVegId() {
		return vegId;
	}
	public void setVegId(Integer vegId) {
		this.vegId = vegId;
	}
	public String getVegName() {
		return vegName;
	}
	public void setVegName(String vegName) {
		this.vegName = vegName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}

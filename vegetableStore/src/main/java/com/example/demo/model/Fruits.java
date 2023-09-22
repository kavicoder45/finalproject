package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fruits {
	
	@Id
	private Integer fruitId;
	private String fruitName;
	private float price;
	
	
	public Fruits(Integer fruitId, String furitName, float price) {
		super();
		this.fruitId = fruitId;
		this.fruitName = furitName;
		this.price = price;
	}

	public Fruits() {
		super();
	}



	public Integer getFruitId() {
		return fruitId;
	}


	public void setFruitId(Integer fruitId) {
		this.fruitId = fruitId;
	}


	public String getFruitName() {
		return fruitName;
	}


	public void setFruitName(String furitName) {
		this.fruitName = furitName;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}
	

}

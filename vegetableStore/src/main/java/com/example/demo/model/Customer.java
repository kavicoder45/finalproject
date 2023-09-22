package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {
  
	@Id
	private Integer customerId;
	private String customerName;
	private String customerMobileNo;
	
	@OneToMany(cascade =  CascadeType.ALL)
	@JoinColumn(name = "fk_fruit")
	private List<Fruits> fruits;
	
	@OneToMany(cascade =  CascadeType.ALL)
	@JoinColumn(name = "fk_vegetable")
	private List<Vegetable> vegetables;
	
	
	public Customer(List<Fruits> fruits, List<Vegetable> vegetables) {
		super();
		this.fruits = fruits;
		this.vegetables = vegetables;
	}


	public List<Vegetable> getVegetables() {
		return vegetables;
	}


	public void setVegetables(List<Vegetable> vegetables) {
		this.vegetables = vegetables;
	}


	public List<Fruits> getFruits() {
		return fruits;
	}


	public void setFruits(List<Fruits> fruits) {
		this.fruits = fruits;
	}


	public Customer(Integer customerId, String customerName, String customerMobileNo) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMobileNo = customerMobileNo;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerMobileNo() {
		return customerMobileNo;
	}


	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}


	public Customer() {
		super();
	}
	
}

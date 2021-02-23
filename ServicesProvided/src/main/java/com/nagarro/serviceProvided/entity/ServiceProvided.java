package com.nagarro.serviceProvided.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceProvided {
	
	public ServiceProvided(String id, String name, Float cost, String categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.categoryId = categoryId;
	}
	String id;
	String name;
	Float cost;
	String categoryId;
	
}

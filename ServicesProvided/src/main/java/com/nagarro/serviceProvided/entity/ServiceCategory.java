package com.nagarro.serviceProvided.entity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ServiceCategory {
	
	public ServiceCategory(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	String id;
	String name;
}

package com.nagarro.service.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service {
	String id;
	String name;
	Float cost;
	ServiceCategory category;
	
}

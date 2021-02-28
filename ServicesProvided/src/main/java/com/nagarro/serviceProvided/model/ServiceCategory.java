package com.nagarro.serviceProvided.model;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ServiceCategory {
	@NotEmpty(message = "Id is mandatory")
	String id;
	@NotEmpty(message="name is mandatory")
	String name;
}

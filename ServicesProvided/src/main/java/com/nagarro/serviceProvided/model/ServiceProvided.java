package com.nagarro.serviceProvided.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceProvided {
	@NotEmpty(message = "Id is mandatory")
	String id;
	@NotEmpty(message = "name is mandatory")

	String name;
	@NotNull(message = "Cost is mandatory")

	Float cost;
	@NotEmpty(message = "category is mandatory")

	String categoryId;

}

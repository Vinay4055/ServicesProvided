package com.nagarro.service.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ServiceCategory {
	String id;
	String name;
	List<ServiceProvided> service;
}

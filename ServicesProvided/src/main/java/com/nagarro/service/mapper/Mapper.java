package com.nagarro.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.service.model.ServiceProvided;



@Component
public class Mapper {
	@Autowired
	ModelMapper modelMapper;

	public ServiceProvided convertServiceReceiverEntityToModel(com.nagarro.service.entity.Service source) {
		return modelMapper.map(source, ServiceProvided.class);
	}

	public com.nagarro.service.entity.Service convertServiceReceiverModelToEntity(ServiceProvided source) {
		return modelMapper.map(source, com.nagarro.service.entity.Service.class);
	}

	
	
}

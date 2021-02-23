package com.nagarro.serviceProvided.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.serviceProvided.model.ServiceCategory;
import com.nagarro.serviceProvided.model.ServiceProvided;



@Component
public class Mapper {
	@Autowired
	ModelMapper modelMapper;

	public ServiceProvided convertServiceProvidedEntityToModel(com.nagarro.serviceProvided.entity.ServiceProvided source) {
		return modelMapper.map(source, ServiceProvided.class);
	}

	public com.nagarro.serviceProvided.entity.ServiceProvided convertServiceProvidedModelToEntity(ServiceProvided source) {
		return modelMapper.map(source, com.nagarro.serviceProvided.entity.ServiceProvided.class);
	}
	public List<ServiceProvided> convertServiceProvidedEntityListToModelList(
			List<com.nagarro.serviceProvided.entity.ServiceProvided> source) {
		List<ServiceProvided> convertedList = new ArrayList<>();

		for (int i = 0; i < source.size(); i++) {
			com.nagarro.serviceProvided.entity.ServiceProvided serviceProvidedEntity = source.get(i);

			ServiceProvided serviceProvidedModel = convertServiceProvidedEntityToModel(serviceProvidedEntity);

			convertedList.add(serviceProvidedModel);

		}
		return convertedList;
	}
	
	public ServiceCategory convertServiceCategoryEntityToModel(com.nagarro.serviceProvided.entity.ServiceCategory source) {
		return modelMapper.map(source, ServiceCategory.class);
	}

	public com.nagarro.serviceProvided.entity.ServiceCategory convertServiceCategoryModelToEntity(ServiceCategory source) {
		return modelMapper.map(source, com.nagarro.serviceProvided.entity.ServiceCategory.class);
	}
	public List<ServiceCategory> convertServiceCategoryEntityListToModelList(
			List<com.nagarro.serviceProvided.entity.ServiceCategory> source) {
		List<ServiceCategory> convertedList = new ArrayList<>();

		for (int i = 0; i < source.size(); i++) {
			com.nagarro.serviceProvided.entity.ServiceCategory serviceProvidedEntity = source.get(i);

			ServiceCategory serviceProvidedModel = convertServiceCategoryEntityToModel(serviceProvidedEntity);

			convertedList.add(serviceProvidedModel);

		}
		return convertedList;
	}
	
	
}

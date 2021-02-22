package com.nagarro.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.service.model.ServiceCategory;
import com.nagarro.service.model.ServiceProvided;



@Component
public class Mapper {
	@Autowired
	ModelMapper modelMapper;

	public ServiceProvided convertServiceProvidedEntityToModel(com.nagarro.service.entity.ServiceProvided source) {
		return modelMapper.map(source, ServiceProvided.class);
	}

	public com.nagarro.service.entity.ServiceProvided convertServiceProvidedModelToEntity(ServiceProvided source) {
		return modelMapper.map(source, com.nagarro.service.entity.ServiceProvided.class);
	}
	public List<ServiceProvided> convertServiceProvidedEntityListToModelList(
			List<com.nagarro.service.entity.ServiceProvided> source) {
		List<ServiceProvided> convertedList = new ArrayList<>();

		for (int i = 0; i < source.size(); i++) {
			com.nagarro.service.entity.ServiceProvided serviceProvidedEntity = source.get(i);

			ServiceProvided serviceProvidedModel = convertServiceProvidedEntityToModel(serviceProvidedEntity);

			convertedList.add(serviceProvidedModel);

		}
		return convertedList;
	}
	
	public ServiceCategory convertServiceCategoryEntityToModel(com.nagarro.service.entity.ServiceCategory source) {
		return modelMapper.map(source, ServiceCategory.class);
	}

	public com.nagarro.service.entity.ServiceCategory convertServiceCategoryModelToEntity(ServiceCategory source) {
		return modelMapper.map(source, com.nagarro.service.entity.ServiceCategory.class);
	}
	public List<ServiceCategory> convertServiceCategoryEntityListToModelList(
			List<com.nagarro.service.entity.ServiceCategory> source) {
		List<ServiceCategory> convertedList = new ArrayList<>();

		for (int i = 0; i < source.size(); i++) {
			com.nagarro.service.entity.ServiceCategory serviceProvidedEntity = source.get(i);

			ServiceCategory serviceProvidedModel = convertServiceCategoryEntityToModel(serviceProvidedEntity);

			convertedList.add(serviceProvidedModel);

		}
		return convertedList;
	}
	
	
}

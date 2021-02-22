package com.nagarro.service.service;

import java.util.List;

import com.nagarro.service.entity.ServiceProvided;

public interface MaintainService {
	public Boolean addService(ServiceProvided serviceProvided);
	public Boolean deleteService(String serviceId);
	public Boolean editService(ServiceProvided serviceProvided);
	public ServiceProvided getServiceById(String serviceId);
//	public List<ServiceProvided> getServiceByCategory(String categoryId);
	public List<ServiceProvided> getAllService();
}

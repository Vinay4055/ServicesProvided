package com.nagarro.serviceProvided.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.serviceProvided.entity.ServiceProvided;
@Service
public interface MaintainService {
	public Boolean addService(ServiceProvided serviceProvided);
	public Boolean deleteService(String serviceId);
	public Boolean editService(ServiceProvided serviceProvided);
	public ServiceProvided getServiceById(String serviceId);
//	public List<ServiceProvided> getServiceByCategory(String categoryId);
	public List<ServiceProvided> getAllService();
	public String getCategoryIdByServiceId(String serviceId);
}

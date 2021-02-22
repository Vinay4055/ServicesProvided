package com.nagarro.service.service;

import java.util.List;

import com.nagarro.service.entity.Service;

public interface MaintainService {
	public Boolean addService();
	public Boolean deleteService();
	public Boolean editService();
	public Service getServiceById();
	public List<Service> getServiceByCategory();
}

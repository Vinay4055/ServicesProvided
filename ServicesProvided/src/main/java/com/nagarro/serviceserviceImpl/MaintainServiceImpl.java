package com.nagarro.serviceserviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nagarro.service.entity.ServiceProvided;
import com.nagarro.service.service.MaintainService;

@Service
public class MaintainServiceImpl implements MaintainService {
	static List<ServiceProvided> serviceProvidedList = new ArrayList<>();

	@Override
	public Boolean addService(ServiceProvided serviceProvided) {
		if (!serviceProvidedList.contains(serviceProvided)) {
			serviceProvidedList.add(serviceProvided);
			return true;
		} else
			return false;
	}

	@Override
	public Boolean deleteService(String serviceId) {
		ServiceProvided serviceProvided = getServiceById(serviceId);
		if (serviceProvided != null) {
			serviceProvidedList.remove(serviceProvided);
			return true;
		}
		return false;
	}

	@Override
	public Boolean editService(ServiceProvided serviceProvided) {
		ServiceProvided searchedServiceProvided = getServiceById(serviceProvided.getId());
		if (searchedServiceProvided != null) {
			searchedServiceProvided.setName(serviceProvided.getName());
			return true;
		} else
			return false;
	}

	@Override
	public ServiceProvided getServiceById(String serviceId) {
		Optional<ServiceProvided> searchedProvided = serviceProvidedList.stream()
				.filter(serviceProvided -> serviceProvided.getId().equals(serviceId)).findFirst();
		if (searchedProvided.isPresent()) {
			return searchedProvided.get();

		}
		return null;
	}

	/*
	 * @Override public List<ServiceProvided> getServiceByCategory(String
	 * categoryId) { // TODO Auto-generated method stub return null; }
	 */

	@Override
	public List<ServiceProvided> getAllService() {

		return serviceProvidedList;
	}

}

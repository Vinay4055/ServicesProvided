package com.nagarro.serviceProvided.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nagarro.serviceProvided.entity.ServiceCategory;
import com.nagarro.serviceProvided.entity.ServiceProvided;
import com.nagarro.serviceProvided.service.MaintainService;

@Service
public class MaintainServiceImpl implements MaintainService {
	static List<ServiceProvided> serviceProvidedList = new ArrayList<>();
	static {
		/*
		 * CategordId 1->Parlour 2->Electricity 3->Plumber
		 */
		serviceProvidedList.add(new ServiceProvided("1", "Hair Cutting Service", 90.0f, "1"));
		serviceProvidedList.add(new ServiceProvided("2", "Fan Repair", 100.0f, "2"));
		serviceProvidedList.add(new ServiceProvided("3", "Beard Setting Service", 50.0f, "1"));
		serviceProvidedList.add(new ServiceProvided("4", "Electricity Meter", 200.0f, "2"));
		serviceProvidedList.add(new ServiceProvided("5", "Water Meter Replacement", 700.0f, "3"));
		serviceProvidedList.add(new ServiceProvided("6", "Bleach", 200.0f, "1"));
		serviceProvidedList.add(new ServiceProvided("7", "Facial", 400.0f, "1"));
		serviceProvidedList.add(new ServiceProvided("8", "Hair Rebounding", 6000.0f, "1"));
		serviceProvidedList.add(new ServiceProvided("9", "Hair Colouring", 200.0f, "1"));

	}

	@Override
	public Boolean addService(ServiceProvided serviceProvided) {
		boolean serviceExist = false;
		for (ServiceProvided existingServiceProvided : serviceProvidedList)
			if (existingServiceProvided.getId().equals(serviceProvided.getId())) {
				serviceExist = true;
				break;

			}
		if (serviceExist)
			return false;
		else {
			serviceProvidedList.add(serviceProvided);
			return true;
		}

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
			searchedServiceProvided.setCategoryId(serviceProvided.getCategoryId());
			searchedServiceProvided.setCost(serviceProvided.getCost());
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

	@Override
	public String getCategoryIdByServiceId(String serviceId) {
		if (getServiceById(serviceId) != null)
			return getServiceById(serviceId).getCategoryId();
		else
			return null;

	}

}

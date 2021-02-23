package com.nagarro.serviceProvided.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nagarro.serviceProvided.entity.ServiceCategory;
import com.nagarro.serviceProvided.service.MaintainCategoryService;
@Service
public class MaintainCategoryServiceImpl implements MaintainCategoryService {

	public static List<ServiceCategory> serviceCategoryList = new ArrayList<>();
	static {
		serviceCategoryList.add(new ServiceCategory("1","Parlour"));
		serviceCategoryList.add(new ServiceCategory("2","Electrician"));
		serviceCategoryList.add(new ServiceCategory("3","Plumber"));
	}
	@Override
	public Boolean createCategory(ServiceCategory serviceCategory) {
		if (!serviceCategoryList.contains(serviceCategory)) {
			serviceCategoryList.add(serviceCategory);
			return true;
		} else
			return false;
	}

	@Override
	public Boolean deleteCategory(String categoryId) {
		ServiceCategory serviceCategory = getCategoryById(categoryId);
		if (serviceCategory != null) {
			serviceCategoryList.remove(serviceCategory);
			return true;
		}
		return false;
	}

	@Override
	public Boolean editCategory(ServiceCategory serviceCategory) {
		ServiceCategory searchedServiceCategory = getCategoryById(serviceCategory.getId());
		if (searchedServiceCategory != null) {
			searchedServiceCategory.setName(serviceCategory.getName());
			return true;
		}
		else
			return false;
	}

	@Override
	public List<ServiceCategory> getAllCategory() {
		// TODO Auto-generated method stub
		return serviceCategoryList;
	}

	@Override
	public ServiceCategory getCategoryById(String categoryId) {
		Optional<ServiceCategory> searchedCategory = serviceCategoryList.stream()
				.filter(serviceCategory -> serviceCategory.getId().equals(categoryId)).findFirst();
		if (searchedCategory.isPresent()) {
			return searchedCategory.get();

		}
		return null;
	}

}

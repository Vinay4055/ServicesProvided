package com.nagarro.serviceserviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nagarro.service.entity.ServiceCategory;
import com.nagarro.service.service.MaintainCategory;

public class MaintainCategoryImpl implements MaintainCategory {

	public static List<ServiceCategory> serviceCategoryList = new ArrayList<>();

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

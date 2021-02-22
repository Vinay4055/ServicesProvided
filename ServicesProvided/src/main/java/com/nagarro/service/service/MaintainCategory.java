package com.nagarro.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.service.entity.ServiceCategory;
@Service
public interface MaintainCategory {
	public Boolean createCategory(ServiceCategory serviceCategory);
	public Boolean deleteCategory(String categoryId);
	public Boolean editCategory(ServiceCategory serviceCategory);
	public List<ServiceCategory> getAllCategory();
	public ServiceCategory getCategoryById(String categoryId);
	
}

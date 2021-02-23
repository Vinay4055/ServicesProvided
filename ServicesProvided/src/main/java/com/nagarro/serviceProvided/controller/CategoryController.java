package com.nagarro.serviceProvided.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.serviceProvided.mapper.Mapper;
import com.nagarro.serviceProvided.model.ServiceCategory;
import com.nagarro.serviceProvided.service.MaintainCategoryService;
@RestController
@RequestMapping("/serviceProvided/category")
public class CategoryController {
	@Autowired
	MaintainCategoryService maintainCategory;
	@Autowired
	Mapper mapper;
	@GetMapping("/{categoryId}")
	public ResponseEntity<ServiceCategory> getCategory(@PathVariable(name="categoryId") String categoryId) {
		ServiceCategory serviceCategory= mapper.convertServiceCategoryEntityToModel(maintainCategory.getCategoryById(categoryId));
		if(serviceCategory != null)
			return new ResponseEntity<ServiceCategory>(serviceCategory,HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	@GetMapping("/")
	public ResponseEntity<List<ServiceCategory>> getAllCategory() {
		List<ServiceCategory> serviceCategoryList= mapper.convertServiceCategoryEntityListToModelList(maintainCategory.getAllCategory());
		if(serviceCategoryList != null)
			return new ResponseEntity<List<ServiceCategory>>(serviceCategoryList,HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/")
	public ResponseEntity<Void> createCategory(@RequestBody @Valid ServiceCategory serviceCategory,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		else {
			Boolean flag = maintainCategory.createCategory(mapper.convertServiceCategoryModelToEntity(serviceCategory));
			if(flag)
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			else
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
			
	}
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<Void> deleteCategory(@PathVariable(name="categoryId")String categoryId){
		Boolean flag = maintainCategory.deleteCategory(categoryId);
		if(flag)
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	@PutMapping("/")
	public ResponseEntity<Void> editCategory(@RequestBody @Valid ServiceCategory serviceCategory,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		else {
			Boolean flag = maintainCategory.editCategory(mapper.convertServiceCategoryModelToEntity(serviceCategory));
			if(flag)
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			else
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
}

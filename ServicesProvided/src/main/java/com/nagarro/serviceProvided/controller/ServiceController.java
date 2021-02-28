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
import com.nagarro.serviceProvided.model.ServiceProvided;
import com.nagarro.serviceProvided.service.MaintainService;

@RestController
@RequestMapping("/serviceProvided")
public class ServiceController {
	@Autowired
	MaintainService maintainService;
	@Autowired
	Mapper mapper;

	@GetMapping("/{serviceId}")
	public ResponseEntity<ServiceProvided> getService(@PathVariable(name = "serviceId") String serviceId) {
		if (maintainService.getServiceById(serviceId) != null) {
			ServiceProvided serviceProvided = mapper
					.convertServiceProvidedEntityToModel(maintainService.getServiceById(serviceId));
			return new ResponseEntity<ServiceProvided>(serviceProvided, HttpStatus.FOUND);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@GetMapping("/findCategoryId/{serviceId}")
	public ResponseEntity<String> getCategoryIdFromService(@PathVariable(name = "serviceId") String serviceId) {
		String categoryId = maintainService.getCategoryIdByServiceId(serviceId);
		if (categoryId != null)
			return new ResponseEntity<String>(categoryId, HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	/*
	 * Will Implement Later as require Many To Many relation ship
	 * 
	 * @GetMapping("/category/{categoryName}") public
	 * ResponseEntity<List<ServiceProvided>>
	 * getServiceByCategory(@PathVariable(name="categoryName") String categoryName)
	 * { List<ServiceProvided> serviceProvidedList =
	 * mapper.convertServiceProvidedEntityListToModelList(maintainService.
	 * getServiceByCategory(categoryName)); if(serviceProvidedList != null) return
	 * new
	 * ResponseEntity<List<ServiceProvided>>(serviceProvidedList,HttpStatus.FOUND);
	 * else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 * 
	 * }
	 */

	@GetMapping("/")
	public ResponseEntity<List<ServiceProvided>> getAllService() {
		if (maintainService.getAllService() != null) {
			List<ServiceProvided> serviceProvidedList = mapper
					.convertServiceProvidedEntityListToModelList(maintainService.getAllService());

			return new ResponseEntity<List<ServiceProvided>>(serviceProvidedList, HttpStatus.FOUND);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PostMapping("/")
	public ResponseEntity<Void> addService(@RequestBody @Valid ServiceProvided serviceProvided,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		} else {
			Boolean flag = maintainService.addService(mapper.convertServiceProvidedModelToEntity(serviceProvided));
			if (flag)
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			else
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

	}

	@DeleteMapping("/{serviceId}")
	public ResponseEntity<Void> deleteService(@PathVariable(name = "serviceId") String serviceId) {
		Boolean flag = maintainService.deleteService(serviceId);
		if (flag)
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/")
	public ResponseEntity<Void> editService(@RequestBody @Valid ServiceProvided serviceProvided,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		} else {
			Boolean flag = maintainService.editService(mapper.convertServiceProvidedModelToEntity(serviceProvided));
			if (flag)
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			else
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}

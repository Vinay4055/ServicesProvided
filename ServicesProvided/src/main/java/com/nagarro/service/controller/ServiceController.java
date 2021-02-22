package com.nagarro.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.service.service.MaintainService;


@RestController
@RequestMapping("/service")
public class ServiceController {
	@Autowired
	MaintainService maintainService;
	@GetMapping("/{serviceId}")
	public void getService(@PathVariable(name="serviceId") String serviceId) {
		
	}
}

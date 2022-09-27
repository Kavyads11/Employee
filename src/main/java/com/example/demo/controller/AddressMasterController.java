package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.AddressBean;
import com.example.demo.bean.EmployeBean;
import com.example.demo.entities.AddressMaster;
import com.example.demo.entities.Department;
import com.example.demo.repository.AddressMasterRepository;
import com.example.demo.service.AddressMasterService;
import com.example.demo.service.DepartmentService;

@RestController
public class AddressMasterController {
	
	@Autowired  //(object creation)
	AddressMasterService addresMasterService;
	
	@Autowired
	AddressMasterRepository addressrepo;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value = "/address/add")
	public String insertAddress(@RequestBody AddressBean address)
	{
		
		return addresMasterService.addAddressMaster(address);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value="/address/update")
	public String updateAddress(@RequestBody AddressBean address)
	{
		return addresMasterService.updateAddress(address);
	}
	
	@GetMapping(path ="/address/findby/{id}")
	public AddressMaster getAddress(@PathVariable int id)
	{
		return addresMasterService.getAddress(id);
	}
	
	@DeleteMapping(path ="/address/delete/{id}")
	public String deleteAddress(@PathVariable int id)
	{
		return addresMasterService.deleteAddress(id);
	}

}

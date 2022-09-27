package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.AddressTypeBean;
import com.example.demo.bean.EmployeBean;
import com.example.demo.entities.AddressType;
import com.example.demo.entities.Department;
import com.example.demo.service.AddressTypeService;

@RestController
public class AddressTypeController {
	
	@Autowired
	AddressTypeService addresstypeService;

	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value="/addresstype/add")
	public AddressType addAddressType(@RequestBody AddressType type)
	{
		return addresstypeService.addAddressType(type);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value="/addresstype/update")
	public AddressType updateAddressType(@RequestBody AddressType type)
	{
		return addresstypeService.updateAddressType(type);
	}
	
	@GetMapping(path ="/addresstype/findby/{id}")
	public AddressType getAddressType(@PathVariable int id)
	{
		return addresstypeService.getAddress(id);
	}
	
	@DeleteMapping(path ="/addresstype/delete/{id}")
	public String deleteAddressType(@PathVariable int id)
	{
		return addresstypeService.deleteAddress(id);
	}
}

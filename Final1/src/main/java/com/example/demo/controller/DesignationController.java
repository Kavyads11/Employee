package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Designation;
import com.example.demo.service.DesignationService;

@RestController
public class DesignationController {
	
	

	@Autowired
	DesignationService designationService;
	
	@PostMapping("/Designation/insert")
	public Designation addDesignation(@RequestBody Designation designation)
	{
		return designationService.saveDesignation(designation);
	}
	
	@GetMapping(path ="/Designation/get/{id}")
	public Designation getDesignation(@PathVariable int id)
	{
		return designationService.getDesignation(id);
	}
	
	@PutMapping("/Designation/update")
	public  Designation updateDesignation(@RequestBody Designation designation)
	{
		return designationService.updateDesignation(designation);
	}
	
	@DeleteMapping(path ="/Designation/delete/{id}")
	public String deleteDesignation(@PathVariable int id)
	{
		return designationService.deleteDesignation(id);
	}

}

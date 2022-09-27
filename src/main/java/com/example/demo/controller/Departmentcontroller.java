package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Department;
import com.example.demo.service.DepartmentService;

@RestController
public class Departmentcontroller {
	
	@Autowired  //(object creation)
	DepartmentService departmentService;
	
	
	
	@PostMapping("/Department/insert")
	public Department addDepartment(@RequestBody Department department)
	{
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping(path ="/Department/findby/{id}")
	public Department getDepartment(@PathVariable int id)
	{
		return departmentService.getDepartment(id);
	}
	
	@PutMapping("/Department/update")
	public  Department updateDepartment(@RequestBody Department department)
	{
		return departmentService.updateDepartment(department);
	}
	
	@DeleteMapping(path ="/Department/{id}")
	public String deleteDepartment(@PathVariable int id)
	{
		return departmentService.deleteDepartment(id);
	}

}

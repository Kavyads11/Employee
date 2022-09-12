package com.example.demo.service;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Department;
import com.example.demo.entities.Designation;

import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.DesignationRepository;

@Transactional //Spring dynamically creates a proxy that implements the same interface(s) as the class that gets annotated
@Service("designationService") // to detected by @Autowired
public class DesignationServiceImpl implements DesignationService{
	

	
	@Autowired //automatically injects the implementation of crudrepo
	private DesignationRepository designationRepository;
	
	public Optional<Designation> find(Integer id)
	{
		return this.designationRepository.findById(id);
	}
	
	public Designation save(Designation emp)
	{
		return designationRepository.save(emp);   // to store the data
	}
	
	public Designation  getDesignation(int id)
	{
		return designationRepository.findById(id).get();
	}
	
	public Designation update(Designation employee) 
	{
		Designation emp= designationRepository.findById(employee.getId()).get();
		emp.setName(employee.getName());
		
		
		return designationRepository.save(emp);
	}
	
	public String delete(int id)
	{
		designationRepository.deleteById(id);
		return "Entity deleted "+id;
	}
	
}

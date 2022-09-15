package com.example.demo.service;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.DependantBean;
import com.example.demo.bean.DesignationBean;
import com.example.demo.bean.EmployeBean;
import com.example.demo.entities.Department;
import com.example.demo.entities.Dependants;
import com.example.demo.entities.Designation;
import com.example.demo.entities.Employe;
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
	
	public Designation saveDesignation(Designation designation)
	{
		return designationRepository.save(designation);   // to store the data
	}
	
	public Designation  getDesignation(int id)
	{
		return designationRepository.findById(id).get();
	}
	
	public Designation updateDesignation(Designation designation) 
	{
		Designation desig= designationRepository.findById(designation.getId()).get();
		desig.setName(designation.getName());
		
		
		return designationRepository.save(desig);
	}
	
	public String deleteDesignation(int id)
	{
		designationRepository.deleteById(id);
		return "Entity deleted "+id;
	}

	
	

	
	
}

package com.example.demo.service;

import java.util.Optional;

import com.example.demo.bean.DependantBean;
import com.example.demo.bean.DesignationBean;
import com.example.demo.bean.EmployeBean;
import com.example.demo.entities.Department;
import com.example.demo.entities.Designation;

public interface DesignationService {
	public Optional<Designation> find(Integer id);
	public Designation saveDesignation(Designation designation);
	public Designation  getDesignation(int id);
	public Designation updateDesignation(Designation designation);
	public String deleteDesignation(int id);

	
	
}

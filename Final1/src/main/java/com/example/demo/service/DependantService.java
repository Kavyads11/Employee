package com.example.demo.service;

import java.util.Optional;

import com.example.demo.bean.DependantBean;
import com.example.demo.bean.EmployeBean;
import com.example.demo.entities.Department;
import com.example.demo.entities.Dependants;
import com.example.demo.entities.Designation;
import com.example.demo.entities.Employe;

public interface DependantService {
	public Optional<Dependants> find(Integer id);
	public Dependants insertDependants(Dependants dependant);
	public Dependants updateDependants(Dependants dependant);
	public boolean deleteDependants(Dependants dependant);
	
	public String addDependant(DependantBean dep);
	public String updateDependant(DependantBean dep);
	
	
}

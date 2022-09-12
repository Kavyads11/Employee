package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entities.Department;
import com.example.demo.entities.Dependants;
import com.example.demo.entities.Designation;
import com.example.demo.entities.Employe;

public interface DependantService {
	public Optional<Dependants> find(Integer id);
	public Dependants insert(Dependants student);
	public Dependants update(Dependants employee);
	public boolean delete(Dependants student);
	
	
}

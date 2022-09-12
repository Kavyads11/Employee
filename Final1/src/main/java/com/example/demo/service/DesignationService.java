package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entities.Department;
import com.example.demo.entities.Designation;

public interface DesignationService {
	public Optional<Designation> find(Integer id);
	public Designation save(Designation student);
	public Designation  getDesignation(int id);
	public Designation update(Designation employee);
	public String delete(int id);

}

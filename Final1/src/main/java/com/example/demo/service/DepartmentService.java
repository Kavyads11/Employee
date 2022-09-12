package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entities.Department;
import com.example.demo.entities.Employe;



public interface DepartmentService {
	public Optional<Department> find(Integer id);
	public Department save(Department student);
	public  Department  getEmployee(int id);
	public Department update(Department employee);
	public String delete(int id);
	
}

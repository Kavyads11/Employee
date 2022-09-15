package com.example.demo.service;

import java.util.Optional;



import com.example.demo.entities.Department;
import com.example.demo.entities.Employe;



public interface DepartmentService {
	public Optional<Department> find(Integer id);
	public Department saveDepartment(Department department);
	public  Department  getDepartment(int id);
	public Department updateDepartment(Department department);
	public String deleteDepartment(int id);
	
}

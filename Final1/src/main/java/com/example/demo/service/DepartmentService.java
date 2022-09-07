package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entities.Department;



public interface DepartmentService {
	public Optional<Department> find(Integer id);

}

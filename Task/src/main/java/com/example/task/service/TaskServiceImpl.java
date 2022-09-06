package com.example.task.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository employeeRepository;

	@Override
	public List<Task> getAllEmployees() {
		return  employeeRepository.findAll() ;
	}

	@Override
	public void saveEmployee(Task employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public Task getEmployeeById(long id) {
		Optional<Task> optional = employeeRepository.findById(id);
		Task employee =null;
		if(optional.isPresent())
		{
			employee=optional.get();
		}
		else
		{
			throw new RuntimeException("Employee not found for id : : "+id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
		
	}
	
	
	


}


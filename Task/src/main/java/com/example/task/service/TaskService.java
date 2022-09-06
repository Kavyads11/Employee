package com.example.task.service;



	import java.util.List;

import com.example.task.model.Task;


	



	public interface TaskService {
		List<Task> getAllEmployees();
		void saveEmployee(Task employee);
		Task getEmployeeById(long Id);
		void deleteEmployeeById(long id);
	}




package com.example.demo.controller;

import java.util.LinkedHashMap;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employe;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeService;


@RestController
public class EmployeController {
	
	@Autowired //tells the spring that, injection need to occur here, then spring searches for that StudentService component and injects it here
	EmployeService studentService;
	
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value="/student/insert")//inserts new student record into the table
	public Map<String,String> insertStudent(
			@RequestParam("name") String name,
			@RequestParam("age") double age,
			@RequestParam("deptid") int deptid){
		//RequestParam gets the value from url, eg: ?name=harry -- here harry mapped to String name
		Map<String,String> message = new LinkedHashMap<>();
		Employe newStudent;
		if(this.departmentService.find(deptid).isPresent()) {
			newStudent = new Employe();
			newStudent.setName(name);
			newStudent.setCgpa(age);
			newStudent.setDepartment(this.departmentService.find(deptid).get());
			
			if(this.studentService.insert(newStudent)!=null) {
				message.put("Success", "New student successfully added!");
				message.put("ID",newStudent.getId().toString());
				message.put("Name", name);
				message.put("CGPA", age+"");
				message.put("Department", this.departmentService.find(deptid).get().getName());
			}
			else
				message.put("Error", "Error cannot add new student");
		}
		else {
			message.put("Error", "Department id "+deptid+" is not found");
		}
		return message;
	}
	
	
	@RequestMapping(value="/student/update") //Updates student table
	public Map<String,String> updateStudent(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("age") double age,@RequestParam("deptid") int deptid){
		System.out.println("\nrunning update");
		Map<String,String> message = new LinkedHashMap<>();
		Employe newStudent;
		if(this.studentService.find(id).isPresent()) {
			if(this.departmentService.find(deptid).isPresent()) {
				newStudent = this.studentService.find(id).get();
				newStudent.setName(name);
				newStudent.setCgpa(age);
				newStudent.setDepartment(this.departmentService.find(deptid).get());
				
				if(this.studentService.update(newStudent)!=null) {
					message.put("Success", "Student details successfully updated");
					message.put("ID",newStudent.getId().toString());
					message.put("Name", name);
					message.put("CGPA", age+"");
					message.put("Department", this.departmentService.find(deptid).get().getName());
				}
				else
					message.put("Error", "Error cannot update student");
			}
			else 
				message.put("Error", "Department id "+deptid+" is not found");
		}
		else
			message.put("Error", "Student id "+id+" is not found");
		
		return message;
	}
	
	
	

}

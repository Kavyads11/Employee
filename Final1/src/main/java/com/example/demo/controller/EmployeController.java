package com.example.demo.controller;

import java.util.Iterator;





import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Department;
import com.example.demo.entities.Dependants;
import com.example.demo.entities.Designation;
import com.example.demo.entities.Employe;

import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.DesignationRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.DependantService;
import com.example.demo.service.DesignationService;
import com.example.demo.service.EmployeService;






@RestController
public class EmployeController {
	
	@Autowired //tells the spring that, injection need to occur here, then spring searches for that StudentService component and injects it here
	EmployeService employeService;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	DesignationService designationService;
	
	@Autowired
	DepartmentRepository departmentrepo;
	
	
	
	@Autowired
	DesignationRepository desigRepo;
	/*
	@RequestMapping(value="/student/insert")//inserts new student record into the table
	public Map<String,String> insertStudent(
			@RequestParam("name") String name,
			@RequestParam("age") double age,
			@RequestParam("deptid") int deptid,
			@RequestParam("desid") int desid){
		//RequestParam gets the value from url, eg: ?name=harry -- here harry mapped to String name
		Map<String,String> message = new LinkedHashMap<>();
		Employe newStudent;
		if(this.departmentService.find(deptid).isPresent()) {
			newStudent = new Employe();
			newStudent.setName(name);
			newStudent.setCgpa(age);
			newStudent.setDepartment(this.departmentService.find(deptid).get());
			newStudent.setDesignation(this.designationService.find(desid).get());
			System.out.println(newStudent);
			
			if(this.employeService.insert(newStudent)!=null) {
				message.put("Success", "New student successfully added!");
				message.put("ID",newStudent.getId().toString());
				message.put("Name", name);
				message.put("Age", age+"");
				message.put("Department", this.departmentService.find(deptid).get().getName());
				message.put("Designation", this.designationService.find(desid).get().getName());
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
	public Map<String,String> updateStudent(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("age") double age,@RequestParam("deptid") int deptid ,@RequestParam("desid") int desid){
		System.out.println("\nrunning update");
		Map<String,String> message = new LinkedHashMap<>();
		Employe newStudent;
		if(this.employeService.find(id).isPresent()) {
			if(this.departmentService.find(deptid).isPresent()) {
				newStudent = this.employeService.find(id).get();
				newStudent.setName(name);
				newStudent.setCgpa(age);
				newStudent.setDepartment(this.departmentService.find(deptid).get());
				newStudent.setDesignation(this.designationService.find(desid).get());
				
				if(this.employeService.update(newStudent)!=null) {
					message.put("Success", "Student details successfully updated");
					message.put("ID",newStudent.getId().toString());
					message.put("Name", name);
					message.put("Age", age+"");
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
	
@RequestMapping(value="/student/findall")// Lists all the student record in the student table
	public List<Map<String,String>> findAll(){
		Map<String,String> message ;
		List<Map<String,String>> listOfMessages = new LinkedList<>();
		Employe foundStudent;
		Iterator<Employe> iterator = this.employeService.findAll().iterator(); //this.studentService.findAll() return Iterator<>
		if(iterator.hasNext()) { // if table is not empty
			while(iterator.hasNext()) {
				foundStudent = iterator.next(); // fetch record one by one
				message = new LinkedHashMap<>(); // to store invidual's info
				message.put("ID", foundStudent.getId().toString());
				message.put("Name", foundStudent.getName());
				message.put("Age", foundStudent.getCgpa().toString());
				message.put("Department", foundStudent.getDepartment().getName());
				message.put("Designation", foundStudent.getDesignation().getName());
				listOfMessages.add(message); // list of individual's info
			}
		}
		else { 
			message = new LinkedHashMap<>();
			message.put("Error","No students found!");
			listOfMessages.add(message);
		}
		return listOfMessages;
	}
	

	//Finds Student details for the given id 
		@RequestMapping(value="/student/find/{id}")
		public Map<String,String> find(@PathVariable Integer id){
			//@PathVariable takes the part of url as value her {id} taken as id value
			Map<String,String> message = new LinkedHashMap<>(); // to store student details
			Employe foundStudent;
			//this.studentService.find(id) returns Optional<> whose methods are isPresent and get()
			if(this.employeService.find(id).isPresent()) { // if the given student id is present
				foundStudent = this.employeService.find(id).get(); //fetches the student record from the database
				//Getting student detail with help of getter methods
				message.put("ID", foundStudent.getId().toString());
				message.put("Name", foundStudent.getName());
				message.put("Age", foundStudent.getCgpa().toString());
				message.put("Department", foundStudent.getDepartment().getName());
			}
			else { 
				message.put("Error","Cannot find student with id "+id);
			}
			return message;
		}
		
		@RequestMapping(value="/student/delete/{id}")//deletes record from student table for the given id
		public Map<String,String> deleteStudent(@PathVariable("id") Integer id){
			System.out.println("\nrunning delete");
			Map<String,String> message = new LinkedHashMap<>();
			Employe oldStudent;
			if(this.employeService.find(id).isPresent()) {	
				oldStudent = this.employeService.find(id).get();
				
				message.put("ID", oldStudent.getId().toString());
				message.put("Name", oldStudent.getName());
				message.put("Age", oldStudent.getCgpa().toString());
				message.put("Department", oldStudent.getDepartment().getName());
				message.put("Designation", oldStudent.getDesignation().getName());
				
				if(this.employeService.delete(oldStudent)) 
					message.put("Success", "Student successfully removed");
				else {
					message.clear();
					message.put("Error", "Error cannot delete student");
				}
			}
			else
				message.put("Error", "Student id "+id+" is not found");
			return message;
		}
	

//----------------------------Department----------------------------------------------------------------//	
	@PostMapping("/Department/insert")
	public Department addEmployee(@RequestBody Department employee)
	{
		return departmentService.save(employee);
	}
	
	@GetMapping(path ="/Department/{id}")
	public Department getDepartment(@PathVariable int id)
	{
		return departmentService.getEmployee(id);
	}
	
	@PutMapping("/Department/update")
	public  Department updateEmployee(@RequestBody Department employee)
	{
		return departmentService.update(employee);
	}
	
	@DeleteMapping(path ="/Department/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		return departmentService.delete(id);
	}
	
	//----------------Designation------------------------------//
	@PostMapping("/Designation/insert")
	public Designation addDesignation(@RequestBody Designation employee)
	{
		return designationService.save(employee);
	}
	
	@GetMapping(path ="/Designation/{id}")
	public Designation getDesignation(@PathVariable int id)
	{
		return designationService.getDesignation(id);
	}
	
	@PutMapping("/Designation/update")
	public  Designation updateDesignation(@RequestBody Designation employee)
	{
		return designationService.update(employee);
	}
	
	@DeleteMapping(path ="/Designation/{id}")
	public String deleteDesignation(@PathVariable int id)
	{
		return designationService.delete(id);
	}
//----------------Dependant---------------------------------//
	
	
	*/

	
	@Autowired
	DependantService dependantService;
	
	
	@RequestMapping(value="/dependant/insert")//inserts new student record into the table
	public Map<String,String> insertStudent(
			@RequestParam("name") String name,
			@RequestParam("age") Double age,
			@RequestParam("relation") String relation,
			@RequestParam("emp_id") int empid){
		//RequestParam gets the value from url, eg: ?name=harry -- here harry mapped to String name
		Map<String,String> message = new LinkedHashMap<>();
		Dependants newStudent;
		if(this.employeService.find(empid).isPresent()) {
			newStudent = new Dependants();
			newStudent.setName(name);
			newStudent.setAge(age);
			newStudent.setRelation(relation);
			newStudent.setEmp_id(this.employeService.find(empid).get());
			System.out.println(newStudent);
			
			if(this.dependantService.insert(newStudent)!=null) {
				message.put("Success", "New student successfully added!");
				message.put("ID",newStudent.getId().toString());
				message.put("Name", name);
				message.put("Age", age+"");
				message.put("Reltion", relation+"");
				message.put("Employe", this.employeService.find(empid).get().getName());
				
			}
			else
				message.put("Error", "Error cannot add new student");
		}
		else {
			message.put("Error", "Employe id "+empid+" is not found");
		}
		return message;
	}
	
	@RequestMapping(value="/student/update") //Updates student table
	public Map<String,String> updateStudent(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("age") Double age,@RequestParam("relation") String relation ,@RequestParam("empid") int empid){
		System.out.println("\nrunning update");
		Map<String,String> message = new LinkedHashMap<>();
		Dependants newStudent;
		if(this.dependantService.find(id).isPresent()) {
			if(this.employeService.find(empid).isPresent()) {
				newStudent = this.dependantService.find(id).get();
				newStudent.setName(name);
				newStudent.setAge(age);
				newStudent.setRelation(relation);
				newStudent.setEmp_id(this.employeService.find(empid).get());
				
				
				if(this.dependantService.update(newStudent)!=null) {
					message.put("Success", "Student details successfully updated");
					message.put("ID",newStudent.getId().toString());
					message.put("Name", name);
					message.put("Age", age+"");
					message.put("Relation", relation+"");
					message.put("Employe", this.employeService.find(empid).get().getName());
				}
				else
					message.put("Error", "Error cannot update student");
			}
			else 
				message.put("Error", "Department id "+empid+" is not found");
		}
		else
			message.put("Error", "Student id "+id+" is not found");
		
		return message;
	}
	
	@RequestMapping(value="/student/find/{id}")
	public Map<String,String> find(@PathVariable Integer id){
		//@PathVariable takes the part of url as value her {id} taken as id value
		Map<String,String> message = new LinkedHashMap<>(); // to store student details
	Dependants foundStudent;
		//this.studentService.find(id) returns Optional<> whose methods are isPresent and get()
		if(this.dependantService.find(id).isPresent()) { // if the given student id is present
			foundStudent = this.dependantService.find(id).get(); //fetches the student record from the database
			//Getting student detail with help of getter methods
			message.put("ID", foundStudent.getId().toString());
			message.put("Name", foundStudent.getName());
			message.put("Relation", foundStudent.getRelation());
			message.put("Age",foundStudent.getAge().toString() );
			message.put("Employee", foundStudent.getEmp_id().getName());
		}
		else { 
			message.put("Error","Cannot find student with id "+id);
		}
		return message;
	}
	
	@RequestMapping(value="/student/delete/{id}")//deletes record from student table for the given id
	public Map<String,String> deleteStudent(@PathVariable("id") Integer id){
		System.out.println("\nrunning delete");
		Map<String,String> message = new LinkedHashMap<>();
	Dependants oldStudent;
		if(this.dependantService.find(id).isPresent()) {	
			oldStudent = this.dependantService.find(id).get();
			
			message.put("ID", oldStudent.getId().toString());
			message.put("Name", oldStudent.getName());
			message.put("Age", oldStudent.getAge().toString());
			
			message.put("Employe", oldStudent.getEmp_id().getName());
			
			if(this.dependantService.delete(oldStudent)) 
				message.put("Success", "Student successfully removed");
			else {
				message.clear();
				message.put("Error", "Error cannot delete student");
			}
		}
		else
			message.put("Error", "Student id "+id+" is not found");
		return message;
	}
}

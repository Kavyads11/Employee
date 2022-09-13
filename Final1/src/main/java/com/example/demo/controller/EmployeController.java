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
	
	
	
	@RequestMapping(value="/employe/insert")//inserts new student record into the table
	public Map<String,String> insertEmploye(
			@RequestParam("name") String name,
			@RequestParam("age") Double age,
			@RequestParam("deptid") Integer deptid,
			@RequestParam("desid") Integer desid){
		//RequestParam gets the value from url, eg: ?name=harry -- here harry mapped to String name
		Map<String,String> message = new LinkedHashMap<>();
		Employe newEmploye;
		if(this.departmentService.find(deptid).isPresent()) {
			newEmploye = new Employe();
			newEmploye.setName(name);
			newEmploye.setCgpa(age);
			newEmploye.setDepartment(this.departmentService.find(deptid).get());
			newEmploye.setDesignation(this.designationService.find(desid).get());
			System.out.println(newEmploye);
			
			if(this.employeService.insertEmploye(newEmploye)!=null) {
				message.put("Success", "New employe successfully added!");
				message.put("ID",newEmploye.getId().toString());
				message.put("Name", name);
				message.put("Age", age+"");
				message.put("Department", this.departmentService.find(deptid).get().getName());
				message.put("Designation", this.designationService.find(desid).get().getName());
			}
			else
				message.put("Error", "Error cannot add new employe");
		}
		else {
			message.put("Error", "Department id "+deptid+" is not found");
		}
		return message;
	}
	
	
	@RequestMapping(value="/Employe/update") //Updates student table
	public Map<String,String> updateEmploye(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("age") Double age,@RequestParam("deptid") Integer deptid ,@RequestParam("desid") Integer desid){
		System.out.println("\nrunning update");
		Map<String,String> message = new LinkedHashMap<>();
		Employe newEmploye;
		if(this.employeService.findEmploye(id).isPresent()) {
			if(this.departmentService.find(deptid).isPresent()) {
				newEmploye = this.employeService.findEmploye(id).get();
				newEmploye.setName(name);
				newEmploye.setCgpa(age);
				newEmploye.setDepartment(this.departmentService.find(deptid).get());
				newEmploye.setDesignation(this.designationService.find(desid).get());
				
				if(this.employeService.updateEmploye(newEmploye)!=null) {
					message.put("Success", "Employe details successfully updated");
					message.put("ID",newEmploye.getId().toString());
					message.put("Name", name);
					message.put("Age", age+"");
					message.put("Department", this.departmentService.find(deptid).get().getName());
				}
				else
					message.put("Error", "Error cannot update employe");
			}
			else 
				message.put("Error", "Department id "+deptid+" is not found");
		}
		else
			message.put("Error", "Employe id "+id+" is not found");
		
		return message;
	}
	
@RequestMapping(value="/employe/findall")// Lists all the student record in the student table
	public List<Map<String,String>> findAllEmploye(){
		Map<String,String> message ;
		List<Map<String,String>> listOfMessages = new LinkedList<>();
		Employe foundEmploye;
		Iterator<Employe> iterator = this.employeService.findAllEmploye().iterator(); //this.studentService.findAll() return Iterator<>
		if(iterator.hasNext()) { // if table is not empty
			while(iterator.hasNext()) {
				foundEmploye = iterator.next(); // fetch record one by one
				message = new LinkedHashMap<>(); // to store invidual's info
				message.put("ID", foundEmploye.getId().toString());
				message.put("Name", foundEmploye.getName());
				message.put("Age", foundEmploye.getCgpa().toString());
				message.put("Department", foundEmploye.getDepartment().getName());
				message.put("Designation", foundEmploye.getDesignation().getName());
				listOfMessages.add(message); // list of individual's info
			}
		}
		else { 
			message = new LinkedHashMap<>();
			message.put("Error","No Employe found!");
			listOfMessages.add(message);
		}
		return listOfMessages;
	}
	

	//Finds Student details for the given id 
		@RequestMapping(value="/employe/find/{id}")
		public Map<String,String> findEmploye(@PathVariable Integer id){
			//@PathVariable takes the part of url as value her {id} taken as id value
			Map<String,String> message = new LinkedHashMap<>(); // to store student details
			Employe foundEmploye;
			//this.studentService.find(id) returns Optional<> whose methods are isPresent and get()
			if(this.employeService.findEmploye(id).isPresent()) { // if the given student id is present
				foundEmploye = this.employeService.findEmploye(id).get(); //fetches the student record from the database
				//Getting student detail with help of getter methods
				message.put("ID", foundEmploye.getId().toString());
				message.put("Name", foundEmploye.getName());
				message.put("Age", foundEmploye.getCgpa().toString());
				message.put("Department", foundEmploye.getDepartment().getName());
			}
			else { 
				message.put("Error","Cannot find employe with id "+id);
			}
			return message;
		}
		
		@RequestMapping(value="/employe/delete/{id}")//deletes record from student table for the given id
		public Map<String,String> deleteEmploye(@PathVariable("id") Integer id){
			System.out.println("\nrunning delete");
			Map<String,String> message = new LinkedHashMap<>();
			Employe oldEmploye;
			if(this.employeService.findEmploye(id).isPresent()) {	
				oldEmploye = this.employeService.findEmploye(id).get();
				
				message.put("ID", oldEmploye.getId().toString());
				message.put("Name", oldEmploye.getName());
				message.put("Age", oldEmploye.getCgpa().toString());
				message.put("Department", oldEmploye.getDepartment().getName());
				message.put("Designation", oldEmploye.getDesignation().getName());
				
				if(this.employeService.deleteEmploye(oldEmploye)) 
					message.put("Success", "Employe successfully removed");
				else {
					message.clear();
					message.put("Error", "Error cannot delete employe");
				}
			}
			else
				message.put("Error", "Employe id "+id+" is not found");
			return message;
		}
	

//----------------------------Department----------------------------------------------------------------//	
	@PostMapping("/Department/insert")
	public Department addDepartment(@RequestBody Department department)
	{
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping(path ="/Department/findby/{id}")
	public Department getDepartment(@PathVariable int id)
	{
		return departmentService.getDepartment(id);
	}
	
	@PutMapping("/Department/update")
	public  Department updateDepartment(@RequestBody Department department)
	{
		return departmentService.updateDepartment(department);
	}
	
	@DeleteMapping(path ="/Department/{id}")
	public String deleteDepartment(@PathVariable int id)
	{
		return departmentService.deleteDepartment(id);
	}
	
	//----------------Designation------------------------------//
	@PostMapping("/Designation/insert")
	public Designation addDesignation(@RequestBody Designation designation)
	{
		return designationService.saveDesignation(designation);
	}
	
	@GetMapping(path ="/Designation/get/{id}")
	public Designation getDesignation(@PathVariable int id)
	{
		return designationService.getDesignation(id);
	}
	
	@PutMapping("/Designation/update")
	public  Designation updateDesignation(@RequestBody Designation designation)
	{
		return designationService.updateDesignation(designation);
	}
	
	@DeleteMapping(path ="/Designation/delete/{id}")
	public String deleteDesignation(@PathVariable int id)
	{
		return designationService.deleteDesignation(id);
	}
//----------------Dependant---------------------------------//
	
	
	

	
	@Autowired
	DependantService dependantService;
	
	
	@RequestMapping(value="/dependant/insert")//inserts new student record into the table
	public Map<String,String> insertDependants(
			@RequestParam("name") String name,
			@RequestParam("age") Double age,
			@RequestParam("relation") String relation,
			@RequestParam("emp_id") Integer empid){
		//RequestParam gets the value from url, eg: ?name=harry -- here harry mapped to String name
		Map<String,String> message = new LinkedHashMap<>();
		Dependants newDependants;
		if(this.employeService.findEmploye(empid).isPresent()) {
			newDependants = new Dependants();
			newDependants.setName(name);
			newDependants.setAge(age);
			newDependants.setRelation(relation);
			newDependants.setEmp_id(this.employeService.findEmploye(empid).get());
			System.out.println(newDependants);
			
			if(this.dependantService.insertDependants(newDependants)!=null) {
				message.put("Success", "New Dependant successfully added!");
				message.put("ID",newDependants.getId().toString());
				message.put("Name", name);
				message.put("Age", age+"");
				message.put("Reltion", relation+"");
				message.put("Employe", this.employeService.findEmploye(empid).get().getName());
				
			}
			else
				message.put("Error", "Error cannot add new dependant");
		}
		else {
			message.put("Error", "Employe id "+empid+" is not found");
		}
		return message;
	}
	
	@RequestMapping(value="/dependant/update") //Updates student table
	public Map<String,String> updateDependants(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("age") Double age,@RequestParam("relation") String relation ,@RequestParam("empid") Integer empid){
		System.out.println("\nrunning update");
		Map<String,String> message = new LinkedHashMap<>();
		Dependants newDependants;
		if(this.dependantService.find(id).isPresent()) {
			if(this.employeService.findEmploye(empid).isPresent()) {
				newDependants = this.dependantService.find(id).get();
				newDependants.setName(name);
				newDependants.setAge(age);
				newDependants.setRelation(relation);
				newDependants.setEmp_id(this.employeService.findEmploye(empid).get());
				
				
				if(this.dependantService.updateDependants(newDependants)!=null) {
					message.put("Success", "Dependants details successfully updated");
					message.put("ID",newDependants.getId().toString());
					message.put("Name", name);
					message.put("Age", age+"");
					message.put("Relation", relation+"");
					message.put("Employe", this.employeService.findEmploye(empid).get().getName());
				}
				else
					message.put("Error", "Error cannot update student");
			}
			else 
				message.put("Error", "Employet id "+empid+" is not found");
		}
		else
			message.put("Error", "Dependant id "+id+" is not found");
		
		return message;
	}
	
	@RequestMapping(value="/dependant/find/{id}")
	public Map<String,String> findDependants(@PathVariable Integer id){
		//@PathVariable takes the part of url as value her {id} taken as id value
		Map<String,String> message = new LinkedHashMap<>(); // to store student details
	Dependants foundDependants;
		//this.studentService.find(id) returns Optional<> whose methods are isPresent and get()
		if(this.dependantService.find(id).isPresent()) { // if the given student id is present
			foundDependants = this.dependantService.find(id).get(); //fetches the student record from the database
			//Getting student detail with help of getter methods
			message.put("ID", foundDependants.getId().toString());
			message.put("Name", foundDependants.getName());
			message.put("Relation", foundDependants.getRelation());
			message.put("Age",foundDependants.getAge().toString() );
			message.put("Employee", foundDependants.getEmp_id().getName());
		}
		else { 
			message.put("Error","Cannot find dependant with id "+id);
		}
		return message;
	}
	
	@RequestMapping(value="/dependant/delete/{id}")//deletes record from student table for the given id
	public Map<String,String> deleteDependants(@PathVariable("id") Integer id){
		System.out.println("\nrunning delete");
		Map<String,String> message = new LinkedHashMap<>();
	Dependants oldDependant;
		if(this.dependantService.find(id).isPresent()) {	
			oldDependant = this.dependantService.find(id).get();
			
			message.put("ID", oldDependant.getId().toString());
			message.put("Name", oldDependant.getName());
			message.put("Age", oldDependant.getAge().toString());
			
			message.put("Employe", oldDependant.getEmp_id().getName());
			
			if(this.dependantService.deleteDependants(oldDependant)) 
				message.put("Success", "Dependants successfully removed");
			else {
				message.clear();
				message.put("Error", "Error cannot delete dependant");
			}
		}
		else
			message.put("Error", "Dependant id "+id+" is not found");
		return message;
	}
}

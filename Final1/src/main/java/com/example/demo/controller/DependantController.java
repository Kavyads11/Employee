package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.DependantBean;
import com.example.demo.bean.EmployeBean;
import com.example.demo.entities.Dependants;
import com.example.demo.entities.Employe;
import com.example.demo.service.DependantService;
import com.example.demo.service.EmployeService;

@RestController
public class DependantController {
	
	@Autowired
	DependantService dependantService;
	

	
	
/*	@RequestMapping(value="/dependant/insert")//inserts new dependantS record into the table
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
	
	@RequestMapping(value="/dependant/update") //Updates dependantS table
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
	
	*/
/*	@GetMapping(value="/dependant/{id}")
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
	}*/
	
/*	@DeleteMapping(value="/dependant/delete/{id}")//deletes record from student table for the given id
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
	*/
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value = "/dependant/add")
	public String insertDependant(@RequestBody DependantBean dep)
	{
		return dependantService.addDependant(dep);
	}
	
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value="/dependant/update")
	public String updateDependant(@RequestBody DependantBean dep)
	{
		return dependantService.updateDependant(dep);
	}
	
	@DeleteMapping(path ="/dependant/delete/{id}")
	public String deleteDependant(@PathVariable int id)
	{
		return dependantService.deleteDependant(id);
	}
	
	@GetMapping(value="/dependant/find/{id}")
	public Map<String,String> findEmployeAddressMaster(@PathVariable Integer id){
		//@PathVariable takes the part of url as value her {id} taken as id value
		Map<String,String> message = new LinkedHashMap<>(); // to store student details
	Dependants Master;
	Master = this.dependantService.getDependants(id); //fetches the student record from the database
			//Getting student detail with help of getter methods
			message.put("ID", Master.getId().toString());
			message.put("Name", Master.getName());
			message.put("Age", Master.getAge().toString());
			message.put("Relation", Master.getRelation());
			message.put("Employe", Master.getEmp_id().getName());
			
		return message;
	}
}

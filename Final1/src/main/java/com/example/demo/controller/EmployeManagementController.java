package com.example.demo.controller;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.EmployeBean;
import com.example.demo.entities.Designation;
import com.example.demo.entities.Employe;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.DesignationService;
import com.example.demo.service.EmployeService;






@RestController
public class EmployeManagementController {
	
	@Autowired //tells the spring that, injection need to occur here, then spring searches for that EmployeService component and injects it here
	EmployeService employeService;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	DesignationService designationService;
	
	static final Logger logger  = LogManager.getLogger(EmployeManagementController.class.getName());
	
/*	@RequestMapping(value="/employe/insert")//inserts new student record into the table
    //@RequestMapping(method = RequestMethod.POST, value = "/insert",
    //    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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
            newEmploye.setAge(age);
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
	
	

	
	
	/*@RequestMapping(value="/Employe/update") //Updates student table
	public Map<String,String> updateEmploye(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("age") Double age,@RequestParam("deptid") Integer deptid ,@RequestParam("desid") Integer desid){
		System.out.println("\nrunning update");
		Map<String,String> message = new LinkedHashMap<>();
		Employe newEmploye;
		if(this.employeService.findEmploye(id).isPresent()) {
			if(this.departmentService.find(deptid).isPresent()) {
				newEmploye = this.employeService.findEmploye(id).get();
				newEmploye.setName(name);
				newEmploye.setAge(age);
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
	*/
	
@GetMapping(value="/employe/findall")// Lists all the student record in the student table
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
				message.put("Age", foundEmploye.getJoiningDate().toString());
				message.put("Department", foundEmploye.getDepartment().getName());
				message.put("Designation", foundEmploye.getDesignation().getName());
				message.put("PermanentAddress", foundEmploye.getAddress().getPermanentAddress());
				message.put("CurrentAddress", foundEmploye.getAddress().getCurrentAddress());
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
		@GetMapping(value="/employe/find/{id}")
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
				message.put("Age", foundEmploye.getJoiningDate().toString());
				message.put("Department", foundEmploye.getDepartment().getName());
				message.put("Designation", foundEmploye.getDesignation().getName());
				message.put("PermanentAddress", foundEmploye.getAddress().getPermanentAddress());
				message.put("CurrentAddress", foundEmploye.getAddress().getCurrentAddress());
			}
			else { 
				message.put("Error","Cannot find employe with id "+id);
			}
			return message;
		}
		
		@DeleteMapping(value="/employe/delete/{id}")//deletes record from student table for the given id
		public Map<String,String> deleteEmploye(@PathVariable("id") Integer id){
			System.out.println("\nrunning delete");
			Map<String,String> message = new LinkedHashMap<>();
			Employe oldEmploye;
			if(this.employeService.findEmploye(id).isPresent()) {	
				oldEmploye = this.employeService.findEmploye(id).get();
				
				message.put("ID", oldEmploye.getId().toString());
				message.put("Name", oldEmploye.getName());
				message.put("Age", oldEmploye.getJoiningDate().toString());
				message.put("Department", oldEmploye.getDepartment().getName());
				message.put("Designation", oldEmploye.getDesignation().getName());
				message.put("CurrentAddress", oldEmploye.getAddress().getCurrentAddress());
				message.put("PermanentAddress", oldEmploye.getAddress().getPermanentAddress());
				
				
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
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value = "/employe/add")
	public String insertEmploye(@RequestBody EmployeBean emp)
	{
		return employeService.addEmploye(emp);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value="/employe/update")
	public String updateEmploye(@RequestBody EmployeBean emp)
	{
		return employeService.updateEmploye(emp);
	}
	



}

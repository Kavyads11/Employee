package com.example.demo.controller;

import java.util.LinkedHashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.EmployeAddressMasterBean;
import com.example.demo.bean.EmployeBean;
//import com.example.demo.entities.AddressMaster;
import com.example.demo.entities.Dependants;
import com.example.demo.entities.Designation;
import com.example.demo.entities.EmployeAddressMaster;
import com.example.demo.service.EmployeAddressMasterService;
import com.example.demo.service.EmployeService;

@RestController
public class EmployeAddressMasterController {
	
	@Autowired //tells the spring that, injection need to occur here, then spring searches for that EmployeService component and injects it here
	EmployeAddressMasterService employeAddressMasterService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value = "/employeaddress/add")
	public String insertEmployeAddressMaster(@RequestBody EmployeAddressMasterBean emp)
	{
		return employeAddressMasterService.addEmployeAddressMaster(emp);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value = "/employeaddress/update")
	public String updateEmployeAddressMaster(@RequestBody EmployeAddressMasterBean emp)
	{
		return employeAddressMasterService.updateEmployeAddressMaster(emp);
	}
	
	@DeleteMapping(path ="/employeaddress/delete/{id}")
	public String deleteAddress(@PathVariable int id)
	{
		return employeAddressMasterService.deleteEmployeAddressMaster(id);
	}
	
	@GetMapping(value="/employeaddress/find/{id}")
	public Map<String,String> findEmployeAddressMaster(@PathVariable Integer id){
		//@PathVariable takes the part of url as value her {id} taken as id value
		Map<String,String> message = new LinkedHashMap<>(); // to store student details
	EmployeAddressMaster Master;
	Master = this.employeAddressMasterService.getEmployeAddressMaster(id); //fetches the student record from the database
			//Getting student detail with help of getter methods
			message.put("ID", Master.getId().toString());
			message.put("Address", Master.getAddress());
			message.put("Type", Master.getType().toString());
			message.put("Employee", Master.getEmpid().getName());
		return message;
	}

}

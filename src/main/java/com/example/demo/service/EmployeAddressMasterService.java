package com.example.demo.service;

import java.util.Optional;


import com.example.demo.bean.EmployeAddressMasterBean;
import com.example.demo.bean.EmployeBean;
//import com.example.demo.entities.AddressMaster;
import com.example.demo.entities.Designation;
import com.example.demo.entities.Employe;
import com.example.demo.entities.EmployeAddressMaster;

public interface EmployeAddressMasterService {
	public String addEmployeAddressMaster(EmployeAddressMasterBean emp);
	public String updateEmployeAddressMaster(EmployeAddressMasterBean emp);
	public String deleteEmployeAddressMaster(int id);
	public  EmployeAddressMaster  getEmployeAddressMaster(int id);
}

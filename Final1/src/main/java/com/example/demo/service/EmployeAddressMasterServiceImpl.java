package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.EmployeAddressMasterBean;
import com.example.demo.entities.AddressMaster;
import com.example.demo.entities.Department;
import com.example.demo.entities.Designation;
import com.example.demo.entities.Employe;
import com.example.demo.entities.EmployeAddressMaster;
import com.example.demo.repository.EmployeAddressMasterRepository;
import com.example.demo.repository.EmployeRepository;


@Transactional
@Service("employeeMasterAddressService")
public class EmployeAddressMasterServiceImpl implements EmployeAddressMasterService {

	
	@Autowired
	private EmployeAddressMasterRepository employeeAddressMasterRepository;
	
	@Override
	public String addEmployeAddressMaster(EmployeAddressMasterBean empadd) {
		EmployeAddressMaster master = new EmployeAddressMaster();
		Employe emp = new Employe();
		emp.setId(empadd.getEmpid().getId());
		master.setAddress(empadd.getAddress());
		master.setType(empadd.getType());
		master.setEmpid(emp);
		employeeAddressMasterRepository.save(master);
		return "emplye address master addedd successfully";
	}
	
	@Override
	public String updateEmployeAddressMaster(EmployeAddressMasterBean empadd) {
		EmployeAddressMaster master = new EmployeAddressMaster();
		Employe emp = new Employe();
		emp.setId(empadd.getEmpid().getId());
		master.setAddress(empadd.getAddress());
		master.setType(empadd.getType());
		master.setEmpid(emp);
		master.setId(empadd.getId());
		employeeAddressMasterRepository.save(master);
		return "emplye address master addedd successfully";
	}

	public  EmployeAddressMaster  getEmployeAddressMaster(int id)
	{
		return employeeAddressMasterRepository.findById(id).get();
	}
	
}

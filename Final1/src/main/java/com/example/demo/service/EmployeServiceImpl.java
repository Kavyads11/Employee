package com.example.demo.service;

import java.util.Optional;



import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employe;
import com.example.demo.repository.EmployeRepository;






@Transactional
@Service("employeeService")
public class EmployeServiceImpl implements EmployeService {
	
	@Autowired
	private EmployeRepository employeeRepository;

	@Override
	public Employe insertEmploye(Employe employee) {
		return this.employeeRepository.save(employee);
	}
	
	@Override
	public Employe updateEmploye(Employe employe) {

		return this.employeeRepository.save(employe);
	}
	
	@Override
	public Optional<Employe> findEmploye(Integer id) {
		
		return this.employeeRepository.findById(id);
	}
	
	@Override
	public Iterable<Employe> findAllEmploye() {
		return this.employeeRepository.findAll();
	}
	
	@Override
	public boolean deleteEmploye(Employe employe) {
		this.employeeRepository.delete(employe);
		return true;
	}


}

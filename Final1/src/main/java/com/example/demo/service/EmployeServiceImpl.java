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
	public Employe insert(Employe employee) {
		return this.employeeRepository.save(employee);
	}
	
	@Override
	public Employe update(Employe student) {

		return this.employeeRepository.save(student);
	}
	
	@Override
	public Optional<Employe> find(Integer id) {
		
		return this.employeeRepository.findById(id);
	}
	
	@Override
	public Iterable<Employe> findAll() {
		return this.employeeRepository.findAll();
	}
	
	@Override
	public boolean delete(Employe student) {
		this.employeeRepository.delete(student);
		return true;
	}


}

package com.example.demo.service;

import java.util.List;


import java.util.Optional;

import com.example.demo.entities.Employe;
import com.example.demo.entities.EmployeJoin;




public interface EmployeService {
	
	public Employe insert(Employe student);
	public Employe update(Employe student);
	public Optional<Employe> find(Integer id);

}

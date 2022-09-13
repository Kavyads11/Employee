package com.example.demo.service;

import java.util.List;



import java.util.Optional;

import com.example.demo.entities.Employe;
import com.example.demo.entities.EmployeJoin;






public interface EmployeService {
	
	public Employe insertEmploye(Employe employe);
	public Employe updateEmploye(Employe employe);
	public Optional<Employe> findEmploye(Integer id);
	public Iterable<Employe> findAllEmploye();
	public boolean deleteEmploye(Employe employe);

}

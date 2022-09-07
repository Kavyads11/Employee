package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employe;
import com.example.demo.entities.EmployeJoin;




@Repository("studentRepository")
public interface EmployeRepository extends CrudRepository<Employe, Integer>{
	
	

}

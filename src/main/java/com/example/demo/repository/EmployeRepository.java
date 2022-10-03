package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employe;




//perform crud operation
@Repository("studentRepository")
public interface EmployeRepository extends  JpaRepository<Employe, Integer>{

	Page<Employe> findAll(Specification<Employe> spec, Pageable page);
	
	
	
	

}

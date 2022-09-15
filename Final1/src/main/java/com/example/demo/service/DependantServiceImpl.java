package com.example.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.bean.DependantBean;
import com.example.demo.entities.Department;
import com.example.demo.entities.Dependants;
import com.example.demo.entities.Designation;
import com.example.demo.entities.Employe;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.DependantRepository;

@Transactional //Spring dynamically creates a proxy that implements the same interface(s) as the class that gets annotated
@Service("dependantService") // to detected by @Autowired
public class DependantServiceImpl implements DependantService {
	
	@Autowired //automatically injects the implementation of crudrepo
	private DependantRepository dependantRepository;
	
	public Optional<Dependants> find(Integer id)
	{
		return this.dependantRepository.findById(id);
	}
	
	public Dependants insertDependants(Dependants dependant)
	{
		return dependantRepository.save(dependant);   // to store the data
	}

	
	public Dependants updateDependants(Dependants dependant) 
	{
		Dependants depend= dependantRepository.findById(dependant.getId()).get();
		depend.setName(dependant.getName());
		
		
		return dependantRepository.save(depend);
	}
	
	@Override
	public boolean deleteDependants(Dependants dependant) {
		this.dependantRepository.delete(dependant);
		return true;
	}


	@Override
	public String addDependant(DependantBean dep) {
		Dependants master=new Dependants();
		Employe emp=new Employe();
		emp.setId(dep.getEmpid().getId());
		master.setAge(dep.getAge());
		master.setName(dep.getName());
		master.setRelation(dep.getRelation());
		master.setEmp_id(emp);
		dependantRepository.save(master);
		return "dependant added succesfully";
	}
	
	@Override
	public String updateDependant(DependantBean dep) {
		Dependants master=new Dependants();
		Employe emp=new Employe();
		emp.setId(dep.getEmpid().getId());
		master.setAge(dep.getAge());
		master.setId(dep.getId());
		master.setName(dep.getName());
		master.setRelation(dep.getRelation());
		master.setEmp_id(emp);
		dependantRepository.save(master);
		return "dependant updated succesfully";
	}
}

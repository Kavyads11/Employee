package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Department;
import com.example.demo.entities.Dependants;

@Repository("dependantRepository")
public interface DependantRepository extends CrudRepository<Dependants, Integer>{

}

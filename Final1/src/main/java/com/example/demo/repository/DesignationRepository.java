package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Designation;


@Repository("designationRepository")
public interface DesignationRepository extends CrudRepository<Designation, Integer>{

}

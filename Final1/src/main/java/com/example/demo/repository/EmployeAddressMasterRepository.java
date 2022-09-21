package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.EmployeAddressMaster;

@RestController("employeaddressmaster")
public interface EmployeAddressMasterRepository extends CrudRepository<EmployeAddressMaster,Integer> {

}

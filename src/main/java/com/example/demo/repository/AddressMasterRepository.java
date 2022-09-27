package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.AddressMaster;


@Repository("addressMaster")
public interface AddressMasterRepository extends CrudRepository<AddressMaster, Integer> {

}

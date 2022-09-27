package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.AddressType;

@Repository("typeRepository")
public interface AddressTypeRepository extends CrudRepository<AddressType, Integer> {

}

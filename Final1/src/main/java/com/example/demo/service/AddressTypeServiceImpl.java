package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.AddressTypeBean;
import com.example.demo.entities.AddressType;
import com.example.demo.entities.Department;
import com.example.demo.repository.AddressTypeRepository;

@Transactional
@Service("typeService")
public class AddressTypeServiceImpl implements AddressTypeService {

	
	@Autowired
	private AddressTypeRepository typeRepository;
	
	@Override
	public AddressType addAddressType(AddressType type) {
		return this.typeRepository.save(type);
	}
	
	@Override
	public AddressType updateAddressType(AddressType type) {
		AddressType t =typeRepository.findById(type.getId()).get();
		t.setAddress(type.getAddress());
		return  typeRepository.save(t);
	}
	
	public  AddressType  getAddress(int id)
	{
		return typeRepository.findById(id).get();
	}
	
	public String deleteAddress(int id)
	{
		typeRepository.deleteById(id);
		return "Entity deleted "+id;
	}

}

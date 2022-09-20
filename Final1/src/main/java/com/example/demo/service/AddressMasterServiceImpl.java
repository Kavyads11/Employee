package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.AddressBean;
import com.example.demo.bean.EmployeBean;
import com.example.demo.entities.AddressMaster;
import com.example.demo.entities.Department;
import com.example.demo.entities.Designation;
import com.example.demo.entities.Employe;
import com.example.demo.repository.AddressMasterRepository;
import com.example.demo.repository.DepartmentRepository;


@Transactional
@Service("addressMasterService")
public class AddressMasterServiceImpl implements AddressMasterService {

	
	@Autowired //automatically injects the implementation of crudrepo
	private AddressMasterRepository addressMasterRepository;
	
	
	@Override
	public String addAddressMaster(AddressBean address) {
		AddressMaster master = new AddressMaster();
		master.setCurrentAddress(address.getCurrentAddress());
		master.setPermanentAddress(address.getPermanentAddress());
		addressMasterRepository.save(master);
		return "Address addedd succesfully";
	}
	
	@Override
	public String updateAddress(AddressBean address) {
		AddressMaster master = new AddressMaster();
		master.setId(address.getId());
		master.setCurrentAddress(address.getCurrentAddress());
		master.setPermanentAddress(address.getPermanentAddress());
		addressMasterRepository.save(master);
		return "employe updated succesfully";
	}
	
	public  AddressMaster  getAddress(int id)
	{
		return addressMasterRepository.findById(id).get();
	}
	
	public String deleteAddress(int id)
	{
		addressMasterRepository.deleteById(id);
		return "Entity deleted "+id;
	}

}

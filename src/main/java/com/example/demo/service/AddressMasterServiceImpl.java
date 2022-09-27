package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.bean.AddressBean;
import com.example.demo.bean.EmployeBean;
import com.example.demo.entities.AddressMaster;
import com.example.demo.entities.Department;
import com.example.demo.entities.Dependants;
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
/*		AddressMaster master = new AddressMaster();
		Employe emp = new  Employe();
		emp.setId(address.getEmp_id().getId());
		master.setCurrentAddress(address.getCurrentAddress());
		master.setPermanentAddress(address.getPermanentAddress());
		master.setOfficeAddress(address.getOfficeAddress());
		master.setEmp_id(emp);
		addressMasterRepository.save(master);
		return "Address addedd succesfully";*/
		
		AddressMaster addressmaster = new AddressMaster();
		Employe emp = new Employe();
		addressmaster.setCurrentAddress(address.getCurrentAddress());
		addressmaster.setOfficeAddress(address.getOfficeAddress());
		addressmaster.setPermanentAddress(address.getPermanentAddress());
		
		
		//addressmaster.setEmp_id(address.getEmp_id());
		AddressMaster master=addressMasterRepository.save(addressmaster);
		if(addressMasterRepository.findById(master.getId()).isPresent())
			return "Successfully Created Role and Users";
		else
			 return "Failed to Create specified Role";
	}
	
	@Override
	public String updateAddress(AddressBean address) {
		AddressMaster master = new AddressMaster();
		Employe emp=new Employe();
		//emp.setId(address.getEmp_id().getId());
		master.setId(address.getId());
		master.setCurrentAddress(address.getCurrentAddress());
		master.setOfficeAddress(address.getOfficeAddress());
		master.setPermanentAddress(address.getPermanentAddress());
	//	master.setEmp_id(emp);
		addressMasterRepository.save(master);
		return "Address updated succesfully";
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

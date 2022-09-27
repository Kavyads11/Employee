package com.example.demo.service;

import com.example.demo.bean.EmployeBean;
import com.example.demo.entities.AddressType;
import com.example.demo.entities.Department;
import com.example.demo.bean.AddressTypeBean;

public interface AddressTypeService {
	public AddressType addAddressType(AddressType type);
	public AddressType updateAddressType(AddressType type);
	public  AddressType  getAddress(int id);
	public String deleteAddress(int id);

}

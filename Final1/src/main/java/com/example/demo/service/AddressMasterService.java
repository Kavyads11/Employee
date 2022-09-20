package com.example.demo.service;


import com.example.demo.bean.AddressBean;
import com.example.demo.bean.EmployeBean;
import com.example.demo.entities.AddressMaster;
import com.example.demo.entities.Department;

public interface AddressMasterService {
	public String addAddressMaster(AddressBean address);
	public String updateAddress(AddressBean address);
	public  AddressMaster  getAddress(int id);
	public String deleteAddress(int id);

}

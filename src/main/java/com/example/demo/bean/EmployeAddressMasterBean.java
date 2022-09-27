package com.example.demo.bean;

import com.example.demo.entities.Employe;
import com.example.demo.entities.AddressType;

public class EmployeAddressMasterBean {
	private int id;
	private String address;
	private AddressType type;
	private Employe empid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public AddressType getType() {
		return type;
	}
	public void setType(AddressType type) {
		this.type = type;
	}
	public Employe getEmpid() {
		return empid;
	}
	public void setEmpid(Employe empid) {
		this.empid = empid;
	}
	public EmployeAddressMasterBean(int id, String address, AddressType type,Employe empid) {
		super();
		this.id = id;
		this.address = address;
		this.type = type;
		this.empid = empid;
	}
	public EmployeAddressMasterBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeAddressMasterBean(String address, AddressType type) {
		super();
		this.address = address;
		this.type = type;
	}
	
	

}

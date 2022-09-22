package com.example.demo.bean;

import java.util.Date;

public class EmployeBean {

	
	private Integer id;
	private String name;
	private Date joiningdate;
	private DesignationBean designation;
	private DepartmentBean department;
	//private AddressBean address;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public EmployeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getjoiningdate() {
		return joiningdate;
	}
	public void setjoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}
	
	public EmployeBean(Integer id, String name, Date joiningdate, DesignationBean designation,
			DepartmentBean department) {
		super();
		this.id = id;
		this.name = name;
		this.joiningdate = joiningdate;
		this.designation = designation;
		this.department = department;
		//this.address = address;
	}
	public DesignationBean getDesignation() {
		return designation;
	}
	public void setDesignation(DesignationBean designation) {
		this.designation = designation;
	}
	public DepartmentBean getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentBean department) {
		this.department = department;
	}
/*	public AddressBean getAddress() {
		return address;
	}
	public void setAddress(AddressBean address) {
		this.address = address;
	}
*/	
	
}

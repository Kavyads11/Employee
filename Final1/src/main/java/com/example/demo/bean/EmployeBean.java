package com.example.demo.bean;

public class EmployeBean {

	
	private Integer id;
	private String name;
	private Double age;
	private DesignationBean designation;
	private DepartmentBean department;

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
	public Double getAge() {
		return age;
	}
	public void setAge(Double age) {
		this.age = age;
	}
	public EmployeBean(Integer id, String name, Double age, DesignationBean designation, DepartmentBean department) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.department = department;
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
	
	
}

package com.example.demo.entities;

public class EmployeJoin {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Double age;
	private String departmentName;
	private String designation;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public EmployeJoin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Double getAge() {
		return age;
	}
	public void setAge(Double age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public EmployeJoin(Integer id, String name, Double age, String departmentName, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.departmentName = departmentName;
		this.designation = designation;
	}
	
	
	
	
	
	

}

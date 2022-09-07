package com.example.demo.entities;

public class EmployeJoin {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Double designation;
	private String departmentName;
	
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
	public Double getDesignation() {
		return designation;
	}
	public void setDesignation(Double designation) {
		this.designation = designation;
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
	public EmployeJoin(Integer id, String name, Double designation, String departmentName) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.departmentName = departmentName;
	}
	
	
	
	
	

}

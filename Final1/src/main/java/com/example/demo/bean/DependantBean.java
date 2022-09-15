package com.example.demo.bean;

public class DependantBean {
	private int id;
	private double age;
	private String relation;
	private String name;
	private EmployeBean emp_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EmployeBean getEmpid() {
		return emp_id;
	}
	public void setEmpid(EmployeBean empid) {
		this.emp_id = empid;
	}
	public DependantBean(int id, int age, String relation, String name, EmployeBean empid) {
		super();
		this.id = id;
		this.age = age;
		this.relation = relation;
		this.name = name;
		this.emp_id = empid;
	}
	public DependantBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

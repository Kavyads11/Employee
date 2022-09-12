package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





@Entity
@Table(name="employe")
public class Employe {

	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Double age;
	private Department department;
	private Designation designation;
	
	
public Employe() {}
	
	public Employe(String name,Double age) {
		this.name = name;
		this.age = age;
	}
	
	public Employe(Integer id,String name,Double age,Department department,Designation designation) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.department = department;
		this.designation=designation;
	}
	
	
	
	public Employe(Integer id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique = true,nullable = false)
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="name",nullable = false)
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	@Column(name="age",nullable = false)
	public Double getCgpa() {
		return this.age;
	}
	
	

	public void setCgpa(Double age) {
		this.age = age;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)//Manytoone since many students belong to one department
	@JoinColumn(name="deptid",nullable = false)
	public Department getDepartment() {
		
		return this.department;
	}
	
	public void setDepartment(Department department) {
		this.department= department;
	}
	
	
	@ManyToOne(fetch=FetchType.LAZY)//Manytoone since many students belong to one department
	@JoinColumn(name="desid",nullable = false)
	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", name=" + name + ", age=" + age + ", department=" + department + ", designation="
				+ designation + "]";
	}
	
}

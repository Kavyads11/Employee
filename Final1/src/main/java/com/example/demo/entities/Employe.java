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
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique = true,nullable = false)
	private Integer id;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="age",nullable = false)
	private Double age;
	
	@ManyToOne(fetch=FetchType.LAZY)//Manytoone since many students belong to one department
	@JoinColumn(name="deptid",nullable = false)
	private Department department;
	
	@ManyToOne(fetch=FetchType.LAZY)//Manytoone since many students belong to one department
	@JoinColumn(name="desid",nullable = false)
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

	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	
	public Double getAge() {
		return this.age;
	}
	
	

	public void setAge(Double age) {
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

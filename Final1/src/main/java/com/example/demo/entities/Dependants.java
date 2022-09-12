package com.example.demo.entities;

import java.io.Serializable;

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
@Table(name="dependants")
public class Dependants implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Employe emp_id;
	private String name;
	private String relation;
	private Double age;
	
	
	public Dependants() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique = true,nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	@ManyToOne(fetch=FetchType.LAZY)//Manytoone since many students belong to one department
	@JoinColumn(name="empid",nullable = false)
	public Employe getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Employe emp_id) {
		this.emp_id = emp_id;
	}
	
	@Column(name="name",nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="relation",nullable = false)
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	@Column(name="age",nullable = false)
	public Double getAge() {
		return age;
	}
	public void setAge(Double age) {
		this.age = age;
	}
	
	public Dependants(String name, String relation, Double age) {
		super();
		this.name = name;
		this.relation = relation;
		this.age = age;
	}
	public Dependants(Integer id, Employe emp_id, String name, String relation, Double age) {
		super();
		this.id = id;
		this.emp_id = emp_id;
		this.name = name;
		this.relation = relation;
		this.age = age;
	}

	
}


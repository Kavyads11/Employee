package com.example.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Service;



@Entity
@Table(name="department")

public class Department implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	
	private Set<Employe> students = new HashSet<Employe>(0);
	
	public Department() {}
	
	public Department(String name) {
		this.name = name;
	}
	
	
	public Department(String name,Set<Employe> students) {
		this.name = name;
		this.students = students;
	}
	
	@Id //specified the primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //uses the database identity column
	@Column(name="id",unique = true,nullable = false) //name is optional is variable name matches table field name
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="name",nullable = false) // nullable checks whether null accepted, before db throws error
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	//Onetomany -- One department may contain many studentes
		@OneToMany(fetch=FetchType.LAZY, mappedBy = "department") //FetchType.Lazy loads the entities only when necessary good when dealing with lots of records
		public Set<Employe> getStudents(){
			return this.students;
		}

		public void setStudents(Set<Employe> students) {
			this.students = students;
		}

}

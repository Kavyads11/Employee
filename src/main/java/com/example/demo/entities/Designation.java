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

@Entity//mapped to database table
@Table(name="DESIGNATION")//add the table name in the particular database

public class Designation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id //specified the primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //uses the database identity column
	@Column(name="ID",unique = true,nullable = false) //name is optional is variable name matches table field name
	private Integer id;
	
	@Column(name="NAME",nullable = false) // nullable checks whether null accepted, before db throws error
	private String name;
	
	//private Set<Employe> students = new HashSet<Employe>(0);
	
	public Designation() {}
	
	public Designation(String name) {
		this.name = name;
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
	/*
	//Onetomany -- One department may contain many studentes
		@OneToMany(fetch=FetchType.LAZY, mappedBy = "designation") //FetchType.Lazy loads the entities only when necessary good when dealing with lots of records
		public Set<Employe> getStudents(){
			return this.students;
		}

		public void setStudents(Set<Employe> students) {
			this.students = students;
		}

		@Override
		public String toString() {
			return "Designation [id=" + id + ", name=" + name + ", students=" + students + "]";
		}
*/
		
}

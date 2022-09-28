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

@Entity//mapped to database table
@Table(name="EMPLOYEADDRESSMASTER")
public class EmployeAddressMaster {
	
	@Id //specified the primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //uses the database identity column
	@Column(name="ID",unique = true,nullable = false) //name is optional is variable name matches table field name
	private Integer id;
	
	@Column(name="STATE",nullable = false) // nullable checks whether null accepted, before db throws error
	private String state;
	
	@Column(name="DISTRICT",nullable = false) // nullable checks whether null accepted, before db throws error
	private String district;
	
	@Column(name="CITY",nullable = false) // nullable checks whether null accepted, before db throws error
	private String city;
	
	
	@Column(name="TYPE",nullable = false) // nullable checks whether null accepted, before db throws error
	private String type;


	


	public EmployeAddressMaster() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "EmployeAddressMaster [id=" + id + ", state=" + state + ", district=" + district + ", city=" + city
				+ ", type=" + type + "]";
	}


	public EmployeAddressMaster(Integer id, String state, String district, String city, String type) {
		super();
		this.id = id;
		this.state = state;
		this.district = district;
		this.city = city;
		this.type = type;
	}


	public EmployeAddressMaster(String state, String district, String city, String type) {
		super();
		this.state = state;
		this.district = district;
		this.city = city;
		this.type = type;
	}


	



	
/*	 @ManyToOne(fetch=FetchType.LAZY)//Manytoone since many employe belong to one employe
	 @JoinColumn(name="EMPID",nullable = false)//used to join the entity
	private Employe empid;*/

	
}

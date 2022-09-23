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
	
	@Column(name="ADDRESS",nullable = false) // nullable checks whether null accepted, before db throws error
	private String Address;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="TYPEID",nullable = false)
	private AddressType Type;
	
	 @ManyToOne(fetch=FetchType.LAZY)//Manytoone since many employe belong to one employe
	 @JoinColumn(name="EMPID",nullable = false)//used to join the entity
	private Employe empid;

	public EmployeAddressMaster(Integer id, String address,AddressType type,Employe empid) {
		super();
		this.id = id;
		Address = address;
		Type = type;
		this.empid = empid;
	}

	public EmployeAddressMaster(String address, AddressType type) {
		super();
		Address = address;
		Type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public AddressType getType() {
		return Type;
	}

	public void setType(AddressType type) {
		Type = type;
	}

	public Employe getEmpid() {
		return empid;
	}

	public void setEmpid(Employe empid) {
		this.empid = empid;
	}

	public EmployeAddressMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

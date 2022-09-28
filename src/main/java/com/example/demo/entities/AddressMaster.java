package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity//mapped to database table
@Table(name="ADDRESSMASTER")//add the table name in the particular database
public class AddressMaster implements Serializable {
	
	@Id //specified the primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //uses the database identity column
	@Column(name="ID",unique = true,nullable = false) //name is optional is variable name matches table field name
	private Integer id;
	
	@Column(name="CURRENTADDRESS",nullable = false) // nullable checks whether null accepted, before db throws error
	private String CurrentAddress;
	
	@Column(name="PERMANENTADDRESS",nullable = false) // nullable checks whether null accepted, before db throws error
	private String PermanentAddress;
	
	@Column(name="OFFICEADDRESS",nullable = false) // nullable checks whether null accepted, before db throws error
	private String OfficeAddress;
	
/*	@ManyToOne(fetch=FetchType.LAZY)//Manytoone since many employe belong to one employe
    @JoinColumn(name="EMPID",nullable = false)//used to join the entity
	 private Employe empid;*/
	
/*	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empId", nullable = false)
	private Employe employeeModel;*/
	

	public String getOfficeAddress() {
		return OfficeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		OfficeAddress = officeAddress;
	}

	

	public AddressMaster(Integer id, String currentAddress, String permanentAddress, String officeAddress) {
		super();
		this.id = id;
		CurrentAddress = currentAddress;
		PermanentAddress = permanentAddress;
		OfficeAddress = officeAddress;
		//this.empid = emp_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurrentAddress() {
		return CurrentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		CurrentAddress = currentAddress;
	}

	public String getPermanentAddress() {
		return PermanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		PermanentAddress = permanentAddress;
	}

	public AddressMaster() {
		super();
		// TODO Auto-generated constructor stub
	}



}

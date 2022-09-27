package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//mapped to database table
@Table(name="Address_TYPE")
public class AddressType implements Serializable {
	
	@Id //specified the primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //uses the database identity column
	@Column(name="Type_ID",unique = true,nullable = false) //name is optional is variable name matches table field name
	private Integer id;
	
	@Column(name="ADDRESS",nullable = false) // nullable checks whether null accepted, before db throws error
	private String Address;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String permanentAddress) {
		Address = permanentAddress;
	}

	public AddressType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressType(Integer id, String currentAddress) {
		super();
		this.id = id;
		Address = currentAddress;
		
	}

	public AddressType(String currentAddress) {
		super();
		Address = currentAddress;
		
	}

	@Override
	public String toString() {
		if(id==1)
			return "CurrentAddress";
		else
			return "PermanentAddress";
		//return "Type [id=" + id + ", Address=" + Address + "]";
	}
	
	
	
	


}

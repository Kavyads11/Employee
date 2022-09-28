package com.example.demo.bean;

import com.example.demo.entities.Employe;
import com.example.demo.entities.AddressType;

public class EmployeAddressMasterBean {
	private int id;
	private String state;
	private String Type;
	private String district;
	private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
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
	public EmployeAddressMasterBean(int id, String state, String type, String district, String city) {
		super();
		this.id = id;
		this.state = state;
		this.Type = type;
		this.district = district;
		this.city = city;
	}
	public EmployeAddressMasterBean(String state, String type, String district, String city) {
		super();
		this.state = state;
		this.Type= type;
		this.district = district;
		this.city = city;
	}
	public EmployeAddressMasterBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
package com.example.demo.bean;

public class AddressTypeBean {
	private Integer id;
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

	public void setAddress(String address) {
		Address = address;
	}

	public AddressTypeBean(Integer id, String address) {
		super();
		this.id = id;
		Address = address;
	}

	public AddressTypeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

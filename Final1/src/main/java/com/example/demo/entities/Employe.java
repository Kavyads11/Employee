package com.example.demo.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity//mapped to database table
@Table(name="EMPLOYE")//add the table name in the particular database
public class Employe {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id//primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)//auto increment
	@Column(name="ID",unique = true,nullable = false)
	private Integer id;
	
	@Column(name="NAME",nullable = false)
	private String name;
	
	@Column(name="JOININGDATE",nullable = false)
	private Date joiningdate;
	
	//Lazy--only fetch the related entities from the database when we use the relationship
	@ManyToOne(fetch=FetchType.LAZY)//Manytoone since many employe belong to one department,
	@JoinColumn(name="DEPTID",nullable = false)//used to join the entity
	private Department department;
	
	@ManyToOne(fetch=FetchType.LAZY)//Manytoone since many employe belong to one department
	@JoinColumn(name="DESID",nullable = false)
	private Designation designation;
	
/*	@OneToMany(fetch=FetchType.LAZY)//Manytoone since many employe belong to one department
	@JoinColumn(name="EMPLOYEADDRESS_ID",nullable = false)
	private List<AddressMaster> addressMaster;*/
	
/*	@ManyToOne(fetch=FetchType.LAZY)//Manytoone since many employe belong to one department
	@JoinColumn(name="ADDRESS_ID",nullable = false)
	private List<AddressList> addressList;*/
	
	

	



public Employe() {}
	
	
	public Employe(String name, Date joiningdate) {
	super();
	this.name = name;
	this.joiningdate = joiningdate;
    }

	
	

/*public List<AddressList> getAddressList() {
		return addressList;
	}


	public void setAddressList(List<AddressList> addressList) {
		this.addressList = addressList;
	}
*/




//	public List<AddressMaster> getAddress() {
//		return addressMaster;
//	}
//
//
//	public void setAddress(List<AddressMaster> addressMaster) {
//		this.addressMaster = addressMaster;
//	}


	public Employe(Integer id) {
		super();
		this.id = id;
	}

	
/*	public List<EmployeAddressMaster> getAddressList() {
		return addressList;
	}


	public void setAddressList(List<EmployeAddressMaster> addressList) {
		this.addressList = addressList;
	}*/


	


	public Integer getId() {
		return this.id;
	}
	
	
	


	public Employe(Integer id, String name, Date joiningdate, Department department, Designation designation) {
	super();
	this.id = id;
	this.name = name;
	this.joiningdate = joiningdate;
	this.department = department;
	this.designation = designation;
	
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
	
	
	public Date getJoiningDate() {
		return this.joiningdate;
	}
	
	

	public void setjoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)//Manytoone since many employe belong to one department
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
		return "Employe [id=" + id + ", name=" + name + ", joiningdate=" + joiningdate + ", department=" + department + ", designation="
				+ designation + "]";
	}


	
	
}

package com.employee.management.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table 
public class Employee {

	public Employee(int id, String empName, String addres, String email, String contactNo) {
		super();
		this.id = id;
		this.empName = empName;
		this.addres = addres;
		this.email = email;
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", addres=" + addres + ", email=" + email
				+ ", contactNo=" + contactNo + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String empName;
	
	private String addres;
	private String email;
	private String contactNo;
	
	
	
    Employee()
    {
    	
    }
    }

package com.global.exception.employee.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "The unique identifier for the employee.", example = "1", required = true, type = "Integer", format = "give id in integer format", minimum = "1", maximum = "100")
	private int id;

	@Schema(description = "The name of the employee.", example = "FirstName LastName", required = true)
	private String empName;

	@Schema(description = "The address of the employee.", example = "123 Main St, Springfield")
	private String addres;

	@Schema(description = "The email address of the employee.", example = "john.doe@example.com", required = true)
	private String email;

	@Schema(description = "The contact number of the employee.", example = "+1234567890")
	private String contactNo;

	public Employee() {

	}
}

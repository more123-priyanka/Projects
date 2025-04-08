package com.employee.management.system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.system.entity.Employee;
import com.employee.management.system.exception.BusinessException;
import com.employee.management.system.exception.ControllerException;
import com.employee.management.system.service.EmployeeService;


@RestController
@RequestMapping("/Custom")
public class MyController {
	@Autowired
	EmployeeService employeeService;
	
	
	

	@GetMapping("/All")
	public ResponseEntity<?> getAllEmployees() {

		try {
			List<Employee> emp = employeeService.findAllEmployee();
			return new ResponseEntity<>(emp, HttpStatus.FOUND);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (RuntimeException e) {
			ControllerException ce = new ControllerException("611", "something went wrong" + e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/Get/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		try {

			Optional<Employee> emp = employeeService.findById(id);
			return new ResponseEntity<Optional<Employee>>(emp, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (RuntimeException e) {
			ControllerException ce = new ControllerException("611", "something went wrong"+e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/Create/{id}")
	public ResponseEntity<?> createNewEmployee(@PathVariable int id ,@RequestBody Employee employee) {
		try {
			Employee emp = employeeService.save(employee);
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);

		}

		catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (RuntimeException e) {
			ControllerException ce = new ControllerException("611", "something went wrong" + e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/Delete/{id}")
	public ResponseEntity<?> deletEmployeeById(@PathVariable int id) {
		try {
			Employee emp = employeeService.deletEmployeeById(id);
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (RuntimeException e) {
			ControllerException ce = new ControllerException("611", "something went wrong" + e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/Update/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable int id,@RequestBody Employee employee) {

	try {	
		Employee updateEmployee= employeeService.save1(id,employee);
		return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
	}
	 catch (BusinessException e){
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (RuntimeException e){
			ControllerException ce = new ControllerException("611", "something went wrong" + e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	
}



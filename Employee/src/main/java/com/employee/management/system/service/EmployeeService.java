package com.employee.management.system.service;

import java.util.List;
import java.util.Optional;

import com.employee.management.system.entity.Employee;

public interface EmployeeService {

	List<Employee> findAllEmployee();

	Optional<Employee> findById(int id);

	Employee save(Employee employee);

	Employee deletEmployeeById(int id);
	
	
	Employee save1(int id, Employee employee);

	

}

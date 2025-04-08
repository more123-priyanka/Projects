package com.global.exception.employee.service;

import java.util.List;
import java.util.Optional;

import com.global.exception.employee.entity.Employee;





public interface EmployeeService {

	List<Employee> findAllEmployee();

	Optional<Employee> findById(int id);

	Employee save(Employee employee);

	Employee deletEmployeeById(int id);

}




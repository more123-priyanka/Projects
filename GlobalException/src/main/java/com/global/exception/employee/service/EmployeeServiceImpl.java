package com.global.exception.employee.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.exception.employee.entity.Employee;
import com.global.exception.employee.exception.EmptyInputException;
import com.global.exception.employee.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo repo;

	@Override
	public List<Employee> findAllEmployee() {

		List<Employee> list = repo.findAll();

		if (list.isEmpty()) {

			throw new EmptyInputException("601", "oops..!!! soryy ,the given list is empty ");
		}
		return list;

	}

	@Override
	public Optional<Employee> findById(int id) {

		Optional<Employee> employee = repo.findById(id);

		if (employee.isEmpty()) {

			throw new NoSuchElementException( "the given id is empty");
		}
		return employee;

	}

	@Override
	public Employee save(Employee employee) {
		Employee emp = repo.save(employee);
		if ( emp.getEmpName().isEmpty() ) {
			throw new EmptyInputException("603", "the given id is empty");
		}
		return emp;

	}

	@Override
	public Employee deletEmployeeById(int id) {
		if(!repo.existsById(id)) {
			throw new NoSuchElementException("the given id is not present");
		}
		repo.deleteById(id);
		return null;
	}
	

}

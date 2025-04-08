package com.employee.management.system.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee.management.system.entity.Employee;
import com.employee.management.system.exception.BusinessException;
import com.employee.management.system.repositiory.EmployeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeRepo repo;
	

	@Override
	public List<Employee> findAllEmployee() {

		List<Employee> list = repo.findAll();

		if (list.isEmpty()) {
			throw new BusinessException("601", "oops..!!! soryy ,the given list is empty ");
		}

		return list;
	}

	@Override
	public Optional<Employee> findById(int id) {
		Optional<Employee> employee = repo.findById(id);

		if (!repo.existsById(id)) {
			throw new BusinessException("603", "the given id is not present");
		}

		return employee;
	}

	@Override
	public Employee save(Employee employee) {
		Employee emp = repo.save(employee);

		if (emp.getEmpName().isEmpty()) {
			throw new BusinessException("604", "Fill all the fields");
		}

		return emp;

	}

	@Override
	public Employee deletEmployeeById(int id) {

		if (!repo.existsById(id)) {
			throw new BusinessException("603", "the given id is not present");
		}
		repo.deleteById(id);
		return null;
	}

	public Employee save1(int id, Employee employee) {
		
		if (!repo.existsById(id)) {
			throw new BusinessException("603", "the given id is not present");
		}
		Employee SavedEmployee=repo.save(employee);
		return SavedEmployee ;
	}

	
     




 



}	



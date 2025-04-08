package com.global.exception.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.exception.employee.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	Employee save(Employee employee );

	void deleteById(Employee employee );
	
	

}

package com.employee.management.system.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.management.system.entity.Employee;


public interface EmployeRepo extends JpaRepository<Employee, Integer> {

	Employee save(int id );

	void deleteById(Employee employee );
	
	
   
    
    
	
	

}

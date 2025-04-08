package com.global.exception.employee.controller;

import java.util.List;
import java.util.NoSuchElementException;
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

import com.global.exception.employee.entity.Employee;
import com.global.exception.employee.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/Global")
@SecurityRequirement(name="scheme1")
public class MyController {

	@Autowired
	EmployeeService employeeService;

	@Operation(summary = "Get  all users ", description = "retrive all users ")
	@ApiResponse(responseCode = "200", description = "succesfully retrive all users"  , content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "Not Found",  content = @Content(mediaType = "application/json"))
	@Schema(example = "Example of an employee object", 
    implementation = Employee.class)

	@GetMapping("/All")
	public List<Employee> getAllEmployees() {

		return employeeService.findAllEmployee();
	}

	@Operation(summary = "Get a user by id", description = "retrive a user based on unique id ")
	@ApiResponse(responseCode = "200", description = "succesfull",  content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "Not Found",  content = @Content(mediaType = "application/json"))
	@Schema(example = "Example of an employee object", 
    implementation = Employee.class)
	@GetMapping("/Get/{id}")
	public Optional<Employee> getById(@PathVariable int id) {
		return employeeService.findById(id);

	}

//	 @Operation(summary = "Get a user by id", description = "Retrieve a user based on unique id")
//	    @ApiResponses(value = {
//	        @ApiResponse(responseCode = "200", description = "Successful"),
//	        @ApiResponse(responseCode = "404", description = "Not Found")
//	    })
//	    @GetMapping("/{id}")
//	    public Optional<Employee>  getUserById(
//	        @Parameter(name = "id", description = "User  ID", required = true)
//	        @PathVariable int id) {
//		 return employeeService.findById(id);
//	    }

	@Operation(summary = "Create new  user ", description = "create new user/ add new user  ")
	@ApiResponse(responseCode = "200", description = "succesfully create user ",  content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "Not Found",  content = @Content(mediaType = "application/json"))
	@Schema(example = "Example of an employee object", 
    implementation = Employee.class)
	@PostMapping("/Create")
	public Employee createNewEmployee(@RequestBody Employee employee) {

		return employeeService.save(employee);
	}

	@Operation(summary = "Delete a user by id", description = "delete a user based on unique id ")
	@ApiResponse(responseCode = "200", description = "succesfully deleted",  content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "Not Found",  content = @Content(mediaType = "application/json"))
	@Schema(example = "Example of an employee object", 
    implementation = Employee.class)
	@DeleteMapping("/Delete/{id}")
	public Employee deletEmployeeById(@PathVariable int id) {

		return employeeService.deletEmployeeById(id);
	}

	@Operation(summary = "Update existing user by id", description = "update  user based on unique id ")
	@ApiResponse(responseCode = "200", description = "succesfully update ")
	@ApiResponse(responseCode = "404", description = "Not Found")
	@Schema(example = "Example of an employee object", 
    implementation = Employee.class)
	@PutMapping("/Update/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {

		Optional<Employee> existingEmployee = employeeService.findById(id);
		if (existingEmployee.isPresent()) {

			if (employee.getEmpName() != null) {

				existingEmployee.get().setEmpName(employee.getEmpName());
			}

			if (employee.getAddres() != null) {
				existingEmployee.get().setAddres(employee.getAddres());
			}

			if (employee.getEmail() != null) {
				existingEmployee.get().setEmail(employee.getEmail());
			}

			if (employee.getContactNo() != null) {
				existingEmployee.get().setContactNo(employee.getContactNo());
			}

		} else {
			throw new NoSuchElementException("The id is not present");

		}

		return employeeService.save(existingEmployee.get());

	}
}

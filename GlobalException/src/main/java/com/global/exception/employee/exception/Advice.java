package com.global.exception.employee.exception;


import java.util.NoSuchElementException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Advice {
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<Object  >emptyInput(EmptyInputException emptyInputException){
	  
		return new ResponseEntity<Object>(emptyInputException,HttpStatus.BAD_REQUEST);
		
	}
   
	
	
	@ExceptionHandler(java.util.NoSuchElementException.class)
	public ResponseEntity<String >noSuchElement(NoSuchElementException noSuchElementException){
		return new ResponseEntity<String>("given id is not present ",HttpStatus.NOT_FOUND);
		
	}
	
	
	
	    
}

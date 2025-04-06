package com.mangement.student.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangement.student.entity.Student;
import com.mangement.student.service.StudentService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	private StudentService studentService;
	private List<Student> student;

	@GetMapping("/Students")
	public List<Student> getAllStudent() {

		return studentService.findAllStudent();
	}

	@GetMapping("/Students/{id}")
	public Optional<Student> getStudentById(@PathVariable int id) {
		return studentService.findStudentById(id);

	}

	@PostMapping("/Students")
	public Student createStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@DeleteMapping("/Students/{id}")
	public void deletStudentById(@PathVariable int id) {
		String st = studentService.deleteById(id);
		return;
	}

	@PutMapping("/Students/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		return studentService.saveStudent(student);

	}
}

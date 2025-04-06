package com.mangement.student.service;

import java.util.List;
import java.util.Optional;

import com.mangement.student.entity.Student;

public interface StudentService {
	public List<Student> findAllStudent();

	String deleteById(Integer id);

	Student saveStudent(Student student);

	public Optional<Student> findStudentById(int id);

	

}

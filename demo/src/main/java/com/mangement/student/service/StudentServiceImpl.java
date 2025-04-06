package com.mangement.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.mangement.student.entity.Student;

import com.mangement.student.repositiory.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;
	
	

	@Override
	public List<Student> findAllStudent() {
		List<Student> list = repo.findAll();

		return list;
	}

	@Override
	public String deleteById(Integer id) {
		repo.deleteById(id);

		return null;

	}

	@Override
	public Student saveStudent(Student student) {
		Student save = repo.save(student);

		return save;

	}

	@Override
	public Optional<Student> findStudentById(int id) {
		Optional<Student> student = repo.findById(id);

		return student;
	}

	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {

		Optional<Student> existingStudent = repo.findById(id);
		if (existingStudent.isPresent()) {
			if (student.getFirstName() != null) {
				existingStudent.get().setFirstName(student.getFirstName());
			}

			if (student.getLastName() != null) {
				existingStudent.get().setLastName(student.getLastName());
			}

			if (student.getEmail() != null) {
				existingStudent.get().setEmail(student.getEmail());
			}
			if (student.getCourse() != null) {
				existingStudent.get().setCourse(student.getCourse());
			}
		}

		return repo.save(existingStudent.get());

	}

	
}
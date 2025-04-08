package com.mangement.student.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mangement.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student save(Student student);

	void deleteById(Student student);

}

package com.mangement.student.techloginService;

import java.util.List;
import java.util.Optional;

import com.mangement.student.entity.Student;
import com.mangement.student.teaclogin.entity.Addmission;

public interface AddService {

	List<Addmission> getAllAdmission();

	Optional<Addmission> findAddmissionById(int id);

	

	String deleteById(int id);



	Addmission Create(Addmission addmission);

	Addmission save(Addmission addmission);

}

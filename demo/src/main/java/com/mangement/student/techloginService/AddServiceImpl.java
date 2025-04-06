package com.mangement.student.techloginService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.mangement.student.teachloginRepositiory.AddmissionRepositiory;
import com.mangement.student.teaclogin.entity.Addmission;

@Service
public class AddServiceImpl implements AddService {
	@Autowired
	AddmissionRepositiory repo;

	@Override
	public List<Addmission> getAllAdmission() {
		
	  List<Addmission> add = repo.findAll() ;
		return add;
	}

	@Override
	public Optional<Addmission> findAddmissionById(int id) {
		Optional<Addmission> add= repo.findById(id);
	    return add ;
	}

	@Override
	public Addmission Create(Addmission addmission) {
		Addmission add= repo.save(addmission);
		return add;
	}

	@Override
	public String deleteById(int id) {
		repo.deleteById(id);
	
		return " deleted succesfully";
	}
	
	public Addmission UpdateAddmission(@PathVariable int id, @RequestBody Addmission addmission) {
		Optional<Addmission> existingAddmission = repo.findById(id);
		if (existingAddmission.isPresent()) {
			if (addmission.getFirstName() != null) {
				existingAddmission.get().setFirstName(addmission.getFirstName());
			}

			if (addmission.getLastName() != null) {
				existingAddmission.get().setLastName(addmission.getLastName());
			}

			if (addmission.getEmail() != null) {
				existingAddmission.get().setEmail(addmission.getEmail());
			}

		}
		
		return repo.save(existingAddmission.get());
	}

	@Override
	public Addmission save(Addmission addmission) {
		Addmission save = repo.save(addmission)	;	
		return  save;
	}


	

}

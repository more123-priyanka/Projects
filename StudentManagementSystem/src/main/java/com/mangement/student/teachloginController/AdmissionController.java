package com.mangement.student.teachloginController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangement.student.teaclogin.entity.Addmission;
import com.mangement.student.techloginService.AddService;



@RestController
@RequestMapping("/api/v2")
@CrossOrigin(origins="http://localhost:4200")
public class AdmissionController {

	@Autowired
	private AddService service;

	@GetMapping("/Addmissions")
	public List<Addmission> getAllAddmission() {
		return service.getAllAdmission();

	}
    
	
	@GetMapping("/Addmissions/{id}")
	public Optional<Addmission> getAddmissionById(@PathVariable int id) {
		return service.findAddmissionById(id);
	}

	
	@PostMapping("/Addmissions")
	public Addmission createAddmission( @RequestBody Addmission addmission) {
		return service.save(addmission);
	}

	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping("/Addmissions/{id}")
	public void deleteAddmission(@PathVariable int id) {
		String msg = service.deleteById(id);
		return ;
		

	}

	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/Addmissions/{id}")
	public Addmission updateAddmission( @PathVariable int id,@RequestBody Addmission addmission) {
		 
		return service.save(addmission)	;}
}

 package com.mangement.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(

		info = @Info(title = "Student Management Project", version = "1.0.0", description = "This Project Is Used To Managed Student Activity", termsOfService = "", contact = @Contact(name = "", email = ""), license = @License(name = "", url = ""

		)))
public class ManagementStudentProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementStudentProjectApplication.class, args);
	}

}

package com.global.exception.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@SecurityScheme(name="scheme1",
                type=SecuritySchemeType.HTTP,
                		bearerFormat="jwt",
                scheme=" bearer")
@OpenAPIDefinition(

		info = @Info(title = "Employee Management Project", version = "1.0.0", description = "This Project Is Used To Managed Employee Activity", termsOfService = "", contact = @Contact(name = "", email = ""), license = @License(name = "", url = ""

		)))
public class GlobalExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobalExceptionApplication.class, args);
	}

}

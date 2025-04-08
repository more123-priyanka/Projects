package com.mangement.student.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme.In;

import java.util.Arrays;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student Management System API")
                        .version("1.0")
                        .description("API for managing students, courses, and enrollments.")
                        .contact(new Contact()
                                .name("Your Name")
                                .url("www.example.com")
                                .email("your-email@example.com")))
                .addSecurityItem(new SecurityRequirement().addList("JWT")) // Add security requirement
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("JWT", createJwtSecurityScheme())); // Define the JWT security scheme
    }

    private SecurityScheme createJwtSecurityScheme() {
        return new SecurityScheme()
                .type(Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .in(In.HEADER)
                .name("Authorization");
    }
}
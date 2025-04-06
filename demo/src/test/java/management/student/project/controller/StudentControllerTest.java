package management.student.project.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mangement.student.controller.StudentController;
import com.mangement.student.entity.Student;
import com.mangement.student.service.StudentService;

public class StudentControllerTest {

	@InjectMocks
	private StudentController studentController;

	@Mock
	private StudentService studentService;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
	}

	@Test
	public void testGetAllStudents() throws Exception {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "John", "Doe", "john@example.com", null, null));
		students.add(new Student(2, "Jane", "Doe", "jane@example.com", null, null));

		when(studentService.findAllStudent()).thenReturn(students);

		mockMvc.perform(get("/api/v1/Students")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].firstName").value("John"))
				.andExpect(jsonPath("$[1].firstName").value("Jane"));
	}

	@Test
	public void testGetStudentById() throws Exception {
		Student student = new Student(1, "John", "Doe", "john@example.com", null, null);
		when(studentService.findStudentById(anyInt())).thenReturn(Optional.of(student));

		mockMvc.perform(get("/api/v1/Students/1")).andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName").value("John"));
	}

	@Test
	public void testCreateStudent() throws Exception {
		Student student = new Student(1, "John", "Doe", "john@example.com", null, null);
		when(studentService.saveStudent(any(Student.class))).thenReturn(student);

		mockMvc.perform(post("/api/v1/Students").contentType("application/json")
				.content("{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john@example.com\"}"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.firstName").value("John"));
	}

	@Test
	public void testDeleteStudentById() throws Exception {
		when(studentService.deleteById(anyInt())).thenReturn("Student deleted");

		mockMvc.perform(delete("/api/v1/Students/1")).andExpect(status().isOk());
	}

}
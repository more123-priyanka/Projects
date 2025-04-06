package management.student.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mangement.student.entity.Student;
import com.mangement.student.repositiory.StudentRepository;
import com.mangement.student.service.StudentServiceImpl;

public class StudentServiceImplTest {

	@InjectMocks
	private StudentServiceImpl studentService;

	@Mock
	private StudentRepository studentRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testFindAllStudent() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "John", "Doe", "john.doe@example.com", null, null));
		students.add(new Student(2, "Jane", "Doe", "jane.doe@example.com", null, null));

		when(studentRepository.findAll()).thenReturn(students);

		List<Student> result = studentService.findAllStudent();

		assertEquals(2, result.size());
		assertEquals("John", result.get(0).getFirstName());
		assertEquals("Jane", result.get(1).getFirstName());
	}

	@Test
	public void testDeleteById() {
		studentService.deleteById(1);
		verify(studentRepository).deleteById(1);
	}

	@Test
	public void testSaveStudent() {
		Student student = new Student(1, "John", "Doe", "john.doe@example.com", null, null);
		when(studentRepository.save(any(Student.class))).thenReturn(student);

		Student savedStudent = studentService.saveStudent(student);

		assertEquals("John", savedStudent.getFirstName());
		assertEquals("Doe", savedStudent.getLastName());
		assertEquals("john.doe@example.com", savedStudent.getEmail());
	}

	@Test
	public void testFindStudentById() {
		Student student = new Student(1, "John", "Doe", "john.doe@example.com", null, null);
		when(studentRepository.findById(anyInt())).thenReturn(Optional.of(student));

		Optional<Student> foundStudent = studentService.findStudentById(1);

		assertTrue(foundStudent.isPresent());
		assertEquals("John", foundStudent.get().getFirstName());
	}

	@Test
	public void testUpdateStudent() {
		Student existingStudent = new Student(1, "John", "Doe", "john.doe@example.com", null, null);
		when(studentRepository.findById(anyInt())).thenReturn(Optional.of(existingStudent));
		when(studentRepository.save(any(Student.class))).thenReturn(existingStudent);

		Student updatedStudent = new Student();
		updatedStudent.setFirstName("Jane");
		updatedStudent.setLastName("Doe");
		updatedStudent.setEmail("jane.doe@example.com");

		Student result = studentService.updateStudent(1, updatedStudent);

		assertEquals("Jane", result.getFirstName());
		assertEquals("Doe", result.getLastName());
		assertEquals("jane.doe@example.com", result.getEmail());
		verify(studentRepository).save(existingStudent); // Verify that save was called
	}
}
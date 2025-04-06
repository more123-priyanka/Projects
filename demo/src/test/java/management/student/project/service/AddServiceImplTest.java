package management.student.project.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mangement.student.teaclogin.entity.Addmission;
import com.mangement.student.techloginService.AddServiceImpl;
import com.mangement.student.teachloginRepositiory.AddmissionRepositiory;

public class AddServiceImplTest {

	@InjectMocks
	private AddServiceImpl addService;

	@Mock
	private AddmissionRepositiory addmissionRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllAdmission() {
		List<Addmission> admissions = new ArrayList<>();
		admissions.add(new Addmission(1, "John", "Doe", "john.doe@example.com", null, 0, null, null));
		admissions.add(new Addmission(2, "Jane", "Doe", "jane.doe@example.com", null, 0, null, null));

		when(addmissionRepository.findAll()).thenReturn(admissions);

		List<Addmission> result = addService.getAllAdmission();

		assertEquals(2, result.size());
		assertEquals("John", result.get(0).getFirstName());
		assertEquals("Jane", result.get(1).getFirstName());
	}

	@Test
	public void testFindAddmissionById() {
		Addmission admission = new Addmission(1, "John", "Doe", "john.doe@example.com", null, 0, null, null);
		when(addmissionRepository.findById(anyInt())).thenReturn(Optional.of(admission));

		Optional<Addmission> foundAdmission = addService.findAddmissionById(1);

		assertTrue(foundAdmission.isPresent());
		assertEquals("John", foundAdmission.get().getFirstName());
	}

	@Test
	public void testCreate() {
		Addmission admission = new Addmission(1, "John", "Doe", "john.doe@example.com", null, 0, null, null);
		when(addmissionRepository.save(any(Addmission.class))).thenReturn(admission);

		Addmission savedAdmission = addService.Create(admission);

		assertEquals("John", savedAdmission.getFirstName());
		assertEquals("Doe", savedAdmission.getLastName());
		assertEquals("john.doe@example.com", savedAdmission.getEmail());
	}

	@Test
	public void testDeleteById() {
		addService.deleteById(1);
		verify(addmissionRepository).deleteById(1);
	}

	@Test
	public void testUpdateAddmission() {
		Addmission existingAdmission = new Addmission(1, "John", "Doe", "john.doe@example.com", null, 0, null, null);
		when(addmissionRepository.findById(anyInt())).thenReturn(Optional.of(existingAdmission));
		when(addmissionRepository.save(any(Addmission.class))).thenReturn(existingAdmission);

		Addmission updatedAdmission = new Addmission();
		updatedAdmission.setFirstName("Jane");
		updatedAdmission.setLastName("Doe");
		updatedAdmission.setEmail("jane.doe@example.com");

		Addmission result = addService.UpdateAddmission(1, updatedAdmission);

		assertEquals("Jane", result.getFirstName());
		assertEquals("Doe", result.getLastName());
		assertEquals("jane.doe@example.com", result.getEmail());
		verify(addmissionRepository).save(existingAdmission); 
	}
	
	  @Test
	    public void testSave() {
	        Addmission admission = new Addmission(1, "John", "Doe", "john.doe@example.com", null, 0, null, null);
	        when(addmissionRepository.save(any(Addmission.class))).thenReturn(admission);

	        Addmission savedAdmission = addService.save(admission);

	        assertEquals("John", savedAdmission.getFirstName());
	        assertEquals("Doe", savedAdmission.getLastName());
	        assertEquals("john.doe@example.com", savedAdmission.getEmail());
	        verify(addmissionRepository).save(admission); 
	    }
}

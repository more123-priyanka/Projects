package Builder.Builder_student.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Student {
	
	private int id;
	private String name;
	private String email;
	private String city;
	private String contactNo;
	private String course;
	
	
	}
	



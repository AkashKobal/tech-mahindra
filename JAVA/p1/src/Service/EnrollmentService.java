
package Service;

import p1. Enrollment;
import java.util.List;

public interface  EnrollmentService {
	
	public int insertStudent( Enrollment s);
	public int updateStudent( Enrollment s,  Enrollment id);
	public int deleteStudent( Enrollment s);
	
	
	public List< Enrollment> fetchAll();
	
	public  Enrollment fetchOneStudent( Enrollment s);
	

}

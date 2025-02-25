package Service;

import java.util.List;

import p1.Student;

public interface StudentService {
	
	public int insertStudent(Student s);
	public int updateStudent(Student s, Student id);
	public int deleteStudent(Student s);
	
	
	public List<Student> fetchAll();
	
	public Student fetchOneStudent(Student s);
	

}

package Service;

import p1.Course;
import java.util.List;

public interface CourseService {
	
	public int insertStudent(Course s);
	public int updateStudent(Course s, Course id);
	public int deleteStudent(Course s);
	
	
	public List<Course> fetchAll();
	
	public Course fetchOneCourse(Course s);
	

}

package UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controllers.StudentController;
import DataSource.MySqlDBConnection;
import Model.Student;
import Repository.StudentRepository;
import Service.StudentServiceImpl;

public class StudentControllerTest3 {

    private MySqlDBConnection connection;
	private StudentRepository repository;
    private StudentServiceImpl studentService;
    private StudentController studentController;

    @BeforeEach
    public void setup() throws Exception {
    	connection=new MySqlDBConnection();
        repository = new StudentRepository(connection);  // Make sure this constructor doesn't have dependencies
        studentService = new StudentServiceImpl(repository);
        studentController = new StudentController(studentService);
    }

    @Test
    public void testInsertStudent() {
    	Student s=new Student("3012","akash","akash@gmail.com","Kalaburagi",2021);
    	assertNotNull(s);  // Modify assertion as needed
        int result=studentController.insertStudent(s);
        assertEquals(1, result, "Student insertion success!");
        // Assert that student was inserted
        
    }
}
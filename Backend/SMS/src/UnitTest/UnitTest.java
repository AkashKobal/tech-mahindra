package UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controller.StudentController;
import DataSource.MySqlDBConnection;
import Model.Student;
import Repository.StudentRepository;
import Service.StudentServiceIMPL;

public class UnitTest {

    private MySqlDBConnection connection;
	private StudentRepository repository;
    private StudentServiceIMPL studentService;
    private StudentController studentController;

    @BeforeEach
    public void setup() throws Exception {
    	connection=new MySqlDBConnection();
        repository = new StudentRepository(connection);  // Make sure this constructor doesn't have dependencies
        studentService = new StudentServiceIMPL(repository);
        studentController = new StudentController(studentService);
    }

    @Test
    public void testInsertStudent() {
    	System.out.println("Test case for insert student");
    	Student s=new Student(3000,"amith","amith@gmail.com","Hyderabad",2021);
    	assertNotNull(s);  // Modify assertion as needed
        int result=studentController.insertStudent(s);
        
        assertEquals(1, result, "Student insertion success!");
        
        // Assert that student was inserted
        }
}

package UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controllers.StudentController;
import Model.Student;
import Service.StudentServiceImpl;

class StudentControllerTest {

    private StudentServiceImpl service;
    private StudentController controller;

    @BeforeEach
    void setUp() {
        service = new StudentServiceImpl(); // Manually creating the service instance
        controller = new StudentController(service);
    }

    @Test
    void testInsertStudent() {
        // Creating a sample student object
        Student student = new Student();
        student.setSid("1");
        student.setSname("Jerin");
        student.setYear(2021);

        // Inserting student and getting the result
        int result = controller.insertStudent(student);

        // Assuming service.insertStudent() returns 1 on successful insertion
        assertEquals(1, result, "Student insertion success!");
    }
}

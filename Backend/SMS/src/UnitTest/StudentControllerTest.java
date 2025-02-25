//package UnitTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//
//import Controller.StudentController;
//import DataSource.MySqlDBConnection;
//import Model.Student;
//import Repository.StudentRepository;
//import Service.StudentServiceIMPL;
//
//public class StudentControllerTest {
//
//	private StudentServiceIMPL service;
//	private StudentRepository controller;
//
//	@BeforeEach
//	void setUp() {
//		service = new StudentServiceIMPL(controller); // Manually creating the service instance
//		controller = new StudentRepository(service);
//	}
//
//	@Test
//	void testInsertStudent() {
//		// Creating a sample student object
//		Student student = new Student();
//		student.setSid(10);
//		student.setSname("Jerin");
//		student.setYear(2021);
//
//		// Inserting student and getting the result
//		int result = controller.insertStudent(student);
//
//		// Assuming service.insertStudent() returns 1 on successful insertion
//		assertEquals(1, result, "Student insertion success!");
//	}
//}

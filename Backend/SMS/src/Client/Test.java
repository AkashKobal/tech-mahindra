package Client;

import Controller.StudentController;
import DataSource.MySqlDBConnection;
import Model.Student;
import Repository.StudentRepository;
import Service.StudentServiceIMPL;

public class Test {
    public static void main(String[] args) {
        try {
            MySqlDBConnection dbConnection = new MySqlDBConnection();
            StudentRepository studentRepository = new StudentRepository(dbConnection);
            StudentServiceIMPL studentService = new StudentServiceIMPL(studentRepository);
            StudentController studentController = new StudentController(studentService);
            Student student = new Student(1, "John Doe", "john@example.com", "123 Street", 2024);
            int result = studentController.insertStudent(student);

            if (result > 0) {
                System.out.println("Student inserted successfully!");
            } else {
                System.out.println("Failed to insert student.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

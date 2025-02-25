package Controller;

import Model.Student;
import Service.StudentServiceIMPL;

public class StudentController {
    private StudentServiceIMPL service;

    // Constructor Injection
    public StudentController(StudentServiceIMPL studentservice) {
        this.service = studentservice;
    }

    public int insertStudent(Student s) {
        return service.insertStudent(s);  // Pass 's' instead of 'null'
    }
}

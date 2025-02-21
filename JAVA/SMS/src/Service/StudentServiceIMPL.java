package Service;

import Model.Student;
import Repository.StudentRepository;

public class StudentServiceIMPL {
    private StudentRepository repository;

    // Constructor for Dependency Injection
    public StudentServiceIMPL(StudentRepository repository) {
        this.repository = repository;
    }

    public int insertStudent(Student s) {
        return repository.insertStudent(s);  // Ensure repository is properly initialized
    }
}

package Service;

import Model.Course;
import Repository.CourseRepository;

public class CourseServiceIMPL {
    private CourseRepository repository;

    // Constructor for Dependency Injection
    public CourseServiceIMPL(CourseRepository repository) {
        this.repository = repository;
    }

    public int insertCourse(Course c) {
        return repository.insertCourse(c);  // Ensure repository is properly initialized
    }
}

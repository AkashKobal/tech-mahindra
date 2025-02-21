package Controller;

import Model.Course;
import Service.CourseServiceIMPL;

public class CourseController {
	
    private CourseServiceIMPL service;

    // Constructor Injection
    public CourseController(CourseServiceIMPL courseservice) {
        this.service = courseservice;
    }

    public int insertCourse(Course c) {
        return service.insertCourse(c);  // Pass 's' instead of 'null'
    }
}
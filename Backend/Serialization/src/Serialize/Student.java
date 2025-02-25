package Serialize;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for version control
    private String id;
    private String name;
    private String email;
    private String city;
    private int year;

    public Student(String id, String name, String email, String city, int year) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.year = year;
    }

    // Getters & Setters (Optional)

    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', email='" + email + 
               "', city='" + city + "', year=" + year + "}";
    }
}

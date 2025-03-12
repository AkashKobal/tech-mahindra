package Presentation;

import java.util.List;

public class Student {
	// id, name, courses, cgpa
	private int id;
	private String name;
	private List<Course> courses;
	private double cgpa;
	
	public Student(int id, String name, List<Course> courses, double cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.courses = courses;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cgpa=" + cgpa + "]";
	}

}

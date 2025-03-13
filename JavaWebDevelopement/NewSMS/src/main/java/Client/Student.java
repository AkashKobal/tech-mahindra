package Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class Student implements Comparable<Student> {

	private int id;
	private String name;
	private double cgpa;

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

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cgpa, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Double.doubleToLongBits(cgpa) == Double.doubleToLongBits(other.cgpa) && id == other.id
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cgpa=" + cgpa + "]";
	}

	public Student(int id, String name, double cgpa) {
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	@Override
	public int compareTo(Student s) {
		return Integer.compare(this.id, s.id);
	}
	

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "John", 8.0));
		list.add(new Student(2, "Don", 9.0));
		list.add(new Student(4, "Mick", 7.0));
		list.add(new Student(9, "Smith", 6.0));
		list.add(new Student(3, "Tom", 5.0));
		list.add(new Student(6, "Jerry", 4.0));

		System.out.println("Before sorting:");
		list.forEach(student -> System.out.println(student));

		// Sorting by ID (default compareTo)
		Collections.sort(list);
		System.out.println("\nAfter sorting by ID:");
		list.forEach(System.out::println);

		// Using Supplier to provide a default Student
		Supplier<Student> studentSupplier = () -> new Student(0, "Default", 0.0);
		Student newStudent = studentSupplier.get(); // Gets a default student

		System.out.println("\nSupplier output:");
		System.out.println(newStudent);
		
		// Using forEach to print all students
		System.out.println("Using forEach to print all students");
		list.stream().forEach(System.out::println);
		System.out.println("******************************");
		
		// Using function and  forEach to print all students
		list.stream().forEach(x -> System.out.println(x));
		System.out.println("******************************");

		
		// Using method reference to print all students
		System.out.println("Using method reference to print all students");
		list.stream().forEach(System.out::println);
		System.out.println("******************************");
		
		// printing the length of each name
		list.stream().forEach(System.out::println);


		
	}
	
	
}
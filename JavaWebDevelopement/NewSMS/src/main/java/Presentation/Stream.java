package Presentation;

import java.util.*;
import java.util.stream.*;
import Presentation.Student;
import Presentation.Course;

public class Stream {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
            new Student(1, "Akash", Arrays.asList(new Course("JAVA", "CSE4001",3), new Course("C++", "CSE4006",2)), 8.3),
            new Student(2, "Sushma", Arrays.asList(new Course("JAVA", "CSE4001",3), new Course("Python", "CSE4007",2)), 9.5),
            new Student(3, "Kavya", Arrays.asList(new Course("C", "CSE4003",3), new Course("Python", "CSE4007",2)), 8.3),
            new Student(4, "Sparsha", Arrays.asList(new Course("C", "CSE4003",3), new Course("Python", "CSE4007",2)), 8.4),
            new Student(4, "Prajwal", Arrays.asList(new Course("PHP", "CSE4004",3), new Course("JavaScript", "CSE4009",2)), 9.0),
            new Student(4, "John", Arrays.asList(new Course("PHP", "CSE4004",3), new Course("JavaScript", "CSE4009",2)),3.2)
        );

        // 1. Print all student names
        System.out.println("All student names:");
        students.stream()
                .map(Student::getName)
                .forEach(System.out::println);
        

        // 2. Filter students with CGPA > 8
        System.out.println("\nStudents with CGPA > 8:");
        students.stream()
                .filter(s -> s.getCgpa() > 8 )
                .forEach(System.out::println);
        
        //        // 2. Filter students with CGPA < 8
        System.out.println("\nStudents with CGPA < 8:");
		students.stream().filter(s -> s.getCgpa() < 8).forEach(System.out::println);
		

        // 3. Total number of students
        long count = students.stream().count();
        System.out.println("\nTotal number of students: " + count);

        // 4. Student with highest CGPA
        Student topper = students.stream()
                .max(Comparator.comparing(Student::getCgpa))
                .orElse(null);
        System.out.println("\nTopper: " + topper);

        // 5. Average CGPA
        double avgCgpa = students.stream()
                .collect(Collectors.averagingDouble(Student::getCgpa));
        System.out.println("\nAverage CGPA: " + avgCgpa);

        // 6. Group students by CGPA
        Map<Double, List<Student>> groupedByCgpa = students.stream()
                .collect(Collectors.groupingBy(Student::getCgpa));
        System.out.println("\nStudents grouped by CGPA: " + groupedByCgpa);

        // 7. All courses taken by all students (flattened)
        System.out.println("\nAll course names:");
        students.stream()
                .flatMap(s -> s.getCourses().stream())
                .map(Course::getCourseName)
                .distinct()
                .forEach(System.out::println);

        // 8. Map of student name to CGPA
        Map<String, Double> nameToCgpa = students.stream()
                .collect(Collectors.toMap(Student::getName, Student::getCgpa));
        System.out.println("\nName to CGPA Map: " + nameToCgpa);

        // 9. Total credits per student
        System.out.println("\nTotal credits per student:");
        students.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        s -> s.getCourses().stream().mapToInt(Course::getCredit).sum()
                ))
                .forEach((name, credits) -> System.out.println(name + ": " + credits + " credits"));

        // 10. Join all student names
        String joinedNames = students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));
        System.out.println("\nAll names joined: " + joinedNames);

        // 11. List of all course IDs
        List<String> courseIds = students.stream()
                .flatMap(s -> s.getCourses().stream())
                .map(Course::getCourseId)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("\nCourse IDs: " + courseIds);
        
        
    }
}
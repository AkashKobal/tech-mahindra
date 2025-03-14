package Section7_Oops;

public class Constructor {

	public String name;
	public int rollNo;
	public int marks;
	public String result;

	// Default Constructor is used to assign default values to instance variables
	// while creating object from other class
	public Constructor() {
		name = "Akash";
		rollNo = 101;
		marks = 80;
		result = "Pass";

	}

	// Parameter Constructor is used to assign new values to instance variables
	// while creating object from other class
	public Constructor(String name, int rollNo, int marks, String result) {
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
		this.result = result;
	}

	public static void main(String[] args) {

		System.out.println("Constructors in Java");

		// Creating a constructor object and accessing default values
		Constructor student = new Constructor();
		System.out.println("Name: " + student.name + "Roll No: " + student.rollNo + "Marks: " + student.marks
				+ "Result: " + student.result);

		// Creating a constructor object and accessing new values
		Constructor student2 = new Constructor("Amit", 102, 90, "Pass");
		// accessing new values
		System.out.println("Name: " + student2.name + "Roll No: " + student2.rollNo + "Marks: " + student2.marks
				+ "Result: " + student2.result);

		Constructor student3 = new Constructor("John", 103, 50, "Fail");
		// accessing new values
		System.out.println("Name: " + student3.name + "Roll No: " + student3.rollNo + "Marks: " + student3.marks
				+ "Result: " + student3.result);

	}

}

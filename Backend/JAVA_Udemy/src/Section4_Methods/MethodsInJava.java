package Section4_Methods;

public class MethodsInJava {
	
	public static void loops(int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.println(i);
		}

	}
	
	// befor return type we can use access modifier like public, private, protected, default 
	// and static keyword is used to call method without creating object
	// double is return type of method (we should specify while creating method)
	// return type is used to return value from method
	// method name is areaOfCircle
	// method parameter is radius
	
	public static double areaOfCircle(int radius) {
		double area = Math.PI * radius * radius;
		System.out.println("Area of circle is: " + area);
		return area;
	}
	
	
	// for this below method we are not using static keyword so we need to create object of class to call this method
	public double squareOfTwoNumbers(int n1, int n2) {
		return Math.pow(n1, n2);
		
	}
	
	

	public static void main(String[] args) {
		System.out.println("Methods in Java");
		loops(1, 10);
		
		System.out.println("******************");
		areaOfCircle(5);
		
		System.out.println("******************");
		
		MethodsInJava sqareOfTwoNumbers = new MethodsInJava();
		System.out.println(sqareOfTwoNumbers.squareOfTwoNumbers(2, 3));
		

	}

}

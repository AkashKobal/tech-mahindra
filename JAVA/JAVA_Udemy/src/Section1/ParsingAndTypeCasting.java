package Section1;

public class ParsingAndTypeCasting {

	public static void main(String[] args) {
		System.out.println("Parsing");

		// parsing is converting a string to a number or a number to a string

		String number = "10";
		int num = Integer.parseInt(number);

		System.out.println(num);

		// Type Casting
		// Type casting is converting one data type to another data type
		// There are two types of type casting
		// 1. Implicit Type Casting (Widening) : converting smaller data type to larger
		// data type, no data loss

		System.out.println("Implicit Type Casting");
		int i = 150;
		double d = i;
		System.out.println(d);

		// 2. Explicit Type Casting (Narrowing) : converting larger data type to smaller
		// data type, data loss may occur

		System.out.println("Explicit Type Casting");
		double d1 = 150.25;
		int i1 = (int) d1;
		System.out.println(i1 + " you can see 0.25 is lost");
	}

}

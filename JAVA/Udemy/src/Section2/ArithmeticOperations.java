package Section2;

public class ArithmeticOperations {

	
	public static void main(String[] args) {
		int a = 5;
		float b = 2.5f;
		double result ;
		float addResult = a + b;
		float subResult = a - b;
		float mulResult = a * b;
		float divResult = a / b;
		float modResult = a % b;
		
		System.out.println("Arithmetic Operations");
		System.out.println("Addition of "+a+" and"+ b+" is : "+ addResult);
		System.out.println("Subtraction of "+a+" and"+ b+" is : "+ subResult);
		System.out.println("Multiplication of "+a+" and"+ b+" is : "+ mulResult);
		System.out.println("Division of "+a+" and"+ b+" is : "+ divResult);
		System.out.println("Modulus of "+a+" and"+ b+" is : "+ modResult);
		
		String s1 = "Hello";
		String s2 = "World";
		
		System.out.println("Concatenating strings"+s1 + s2);
		
	
	}

}

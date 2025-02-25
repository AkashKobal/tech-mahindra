package Section1;

public class SloveAnEquation {
	public static void main(String[] args) {
		System.out.println("Solving an Equation");
		// (a+b)^2 = a^2 + b^2 + 2ab
		
		int a = 5;
		float b = 2.5f;
		double result ;
		result = (a*a)+(b*b)+(2*a*b);
		
		System.out.println("Result of the equation is : "+result);
		
		// Converting the result to only integer value, use type casting  
		
		int resultInInteger =  (int)(result);
		System.out.println("Result of the equation in integer is : "+resultInInteger);
	}

}

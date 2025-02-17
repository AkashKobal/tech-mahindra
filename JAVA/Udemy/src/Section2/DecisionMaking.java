package Section2;

public class DecisionMaking {
	public static void main(String[] args) {
		System.out.println("Decision Making");
		
		// if condition
		int a = 10;
		int b = 20;
		
		if (a > b) {
			System.out.println("a is greater than b");
		}
		
		
		// if else condition
		if (a > b) {
			System.out.println("a is greater than b");
		} else {
			System.out.println("b is greater than a");
		}
		
		// if else if condition
		
		if (a > b) {
			System.out.println("a is greater than b");
		} else if (a < b) {
			System.out.println("b is greater than a");
		} else {
			System.out.println("a is equal to b");
		}
	}

}

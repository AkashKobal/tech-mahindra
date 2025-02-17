package Section2;

public class DecisionMaking {
	
	// return

//	The return statement is used to exit a method and optionally return a value to the caller.
//	It plays a crucial role in controlling the flow of a program. When a return statement is encountered, 
//	he current method's execution stops, and the specified value (if any) is passed back to the calling code. 
	
	public int add(int a1, int b1) {
	    return a1 + b1;
	}

//	System.out.println() Statement
//	System.out.println() is a method used to print text or data to the console (standard output). 
//	It's primarily used for displaying information to the user or for debugging purposes. It doesn't return any value and doesn't affect the program's control flow in the same way as return

	
	public void printMessage(String message) {
	    System.out.println(message);
	}

	int result = add(5, 3); // result will be 8
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

		// Nested if else condition
		int x = 30;
		int y = 40;
		if (x > y) {
			if (x == 30) {
				System.out.println("x is 30");
			} else {
				System.out.println("x is greater than y");

			}
		} else {
			System.out.println("x is less than y");
		}

		// Switch case
		int day = 3;
		switch (day) {
		case 1: {
			System.out.println("Sunday");
			break;
		}
		case 2: {
			System.out.println("Monday");
			break;
		}
		case 3: {
			System.out.println("Tuesday");
			break;

		}
		case 4: {
			System.out.println("Wednesday");
			break;
		}
		case 5: {
			System.out.println("Thursday");
			break;
		}
		case 6: {
			System.out.println("Friday");
			break;

		}
		case 7: {
			System.out.println("Saturday");
			break;

		}

		default:
			System.out.println("Invalid day");
		}

		// Jump Statements : break, continue, return
		// break
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				break;
			}
			System.out.println(i);
		}

		// continue
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				System.out.println("five found and skpied");
				continue;
			}
			System.out.println(i);
		}
		
		// return 
		DecisionMaking decisionMaking = new DecisionMaking();
		decisionMaking.printMessage("Hello, World!"); 
		System.out.println(decisionMaking.add(50, 50)); 
		
		//Ternary Operator
		int age = 20;
		String eligibleAge = (age > 18)? "Eligible to vote ": "Not eligible to vote";
		System.out.println(eligibleAge);
		

		
	}

}

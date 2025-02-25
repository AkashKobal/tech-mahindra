package Section3_FlowControl;

public class Loops {
	public static void main(String[] args) {
		System.out.println("For Loop");

		// for loop
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}

		// do while

		int a = 10;

		do {
			System.out.println("Do while loop " + a);
			a++;

		} while (a < 15);
		
		int b = 10;
		// while loop
		while (b < 15) {
			System.out.println("While loop " + b);
            b++;
		}
		
		// for each loop
		int arr[] = { 1, 2, 3, 4, 5 };
		for (int i : arr) {
			System.out.println(i);
		}
		
		int arr2[] = {10, 20, 30, 40, 50};
		for (int i : arr2) {
			System.out.println(i);
        }
		
		// sum of digit
		int num = 1234;
		int sum = 0;
		while (true) {
			System.out.println("Mod "+num%10);
			num = num/10;
			sum = sum + num%10;
			System.out.println(num);
			if (num == 0) {
				break;
			}
			
		}
		System.out.println("Sum of digits is "+sum);
		
	}

}

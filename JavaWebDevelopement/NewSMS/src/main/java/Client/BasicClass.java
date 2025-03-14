package Client;

public class BasicClass {
	
	public static void main(String[] args) {
		// convert into octal number or find octal number
		System.out.println("convert into octal number or find octal number");
		int number = 10;
		System.out.println("Octal number of 10 is: " + Integer.toOctalString(number));
		System.out.println("Hexadecimal number of 10 is: " + Integer.toHexString(number));
		System.out.println("Binary number of 10 is: " + Integer.toBinaryString(number));
		
		// convert into hexadecimal number or find hexadecimal number
		System.out.println("convert into hexadecimal number or find hexadecimal number");
		int number1 = 10;
		System.out.println("Octal number of 10 is: " + Integer.toOctalString(number1));
		System.out.println("Hexadecimal number of 10 is: " + Integer.toHexString(number1));
		System.out.println("Binary number of 10 is: " + Integer.toBinaryString(number1));
		
		// bitwise operators
		System.out.println("Bitwise Operators");
		
		int a = 10;
		int b = 20;
		System.out.println("a & b = " + (a & b));
		System.out.println("a | b = " + (a | b));
		System.out.println("a ^ b = " + (a ^ b));
		System.out.println("~a = " + ~a);
		System.out.println("a << 2 = " + (a << 2));
		System.out.println("a >> 2 = " + (a >> 2));
		System.out.println("a >>> 2 = " + (a >>> 2));
		
		
		// Arithmatic / Logical Statements
		System.out.println("Arithmatic / Logical Statements");
		int x = 10;
		int y = 20;
		int z = 30;
		System.out.println("X = " + x);
		System.out.println("Y = " + y);
		System.out.println("Z = " + z);
		System.out.println("x + y * z = " + (x + y * z));
		System.out.println("x + y - z = " + (x + y - z));
		System.out.println("x * y / z = " + (x * y / z));
		System.out.println("x % y = " + (x % y));
		System.out.println("x++ = " + (x++));
		System.out.println("++x = " + (++x));
		System.out.println("x-- = " + (x--));
		System.out.println("--x = " + (--x));
		System.out.println("x + y = " + (x + y));
		System.out.println("x - y = " + (x - y));
		System.out.println("x * y = " + (x * y));
		System.out.println("x / y = " + (x / y));
		System.out.println("x % y = " + (x % y));
		System.out.println("x == y = " + (x == y));
		System.out.println("x != y = " + (x != y));
		System.out.println("x > y = " + (x > y));
		System.out.println("x < y = " + (x < y));
		System.out.println("x >= y = " + (x >= y));
		System.out.println("x <= y = " + (x <= y));
		
		// Logical Operators
		System.out.println("Logical Operators");
		boolean p = true;
		boolean q = false;
		System.out.println("p && q = " + (p && q));
		System.out.println("p || q = " + (p || q));
		System.out.println("!(p && q) = " + !(p && q));
		
		// Assignment Operators
		System.out.println("Assignment Operators");
		int m = 10;
		int n = 20;
		m += n;
		System.out.println("m += n: " + m);
		m -= n;
		System.out.println("m -= n: " + m);
		m *= n;
		System.out.println("m *= n: " + m);
		m /= n;
		System.out.println("m /= n: " + m);
		m %= n;
		System.out.println("m %= n: " + m);
		
		
		// Unsigned Right Shift Operator
		System.out.println("Unsigned Right Shift Operator");
		int a1 = 20;
		int b1 = -20;
		System.out.println("a1 >> 2 = " + (a1 >> 2)); 
		//10100
		
		System.out.println("b1 >> 2 = " + (b1 >> 2));
		System.out.println("b1 >>> 2 = " + (b1 >>> 2));
		
		// Left Shift Operator
		System.out.println("Left Shift Operator");
		int x2 = 20;
		int y2 = -20;
		System.out.println("x2 << 2 = " + (x2 << 2));
		System.out.println("y2 << 2 = " + (y2 << 2));
		
		
		
		// Ternary Operator
		System.out.println("Ternary Operator");
		int x1 = 10;
		int y1 = 20;
		int result = (x1 > y1) ? x1 : y1;
		System.out.println("Result = " + result);
		
		
		// Exercise
		System.out.println("Exercies");
		int a5 = 20;
		int b5 = 10;
		int c5 = 30;
		int d5 = 40;
		int e5 = 50;
		int f5 = 60;
		
		// a+b/d
		System.out.println("a+b/d = " + (a5 + b5 / d5));
		
		// a+b*d-f/f
		System.out.println("a+b*d-f/f = " + (a5 + b5 * d5 - f5 / f5));
		
		// +a+b
		System.out.println("+a+b = " + (+a5 + b5));
		
		// a+b
		System.out.println("a+b = " + (a5 + b5));
		
		// compound operators
		System.out.println("Compound Operators");
		int a2 = 10;
		int b2 = 20;
		a2 += 4;
		b2 -= 4;
			
		System.out.println("a2 += 4: " + a2);
		System.out.println("b2 -= 4: " + b2);
		
		
		
		
	}

}

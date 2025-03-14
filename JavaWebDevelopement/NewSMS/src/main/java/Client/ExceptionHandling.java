package Client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandling {

	public static void main(String[] args) {
		// Arithmetic Exception
		System.out.println("Arithmetic Exception");
		try {
			int a = 10;
			int b = 0;
			int c = a / b;
			System.out.println("Value of c is: " + c);
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by zero");
		}

		// Array Index Out Of Bounds Exception
		System.out.println("Array Index Out Of Bounds Exception");
		try {
			int[] arr = new int[5];
			arr[6] = 10;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index out of bounds");
		}

		// Null Pointer Exception
		System.out.println("Null Pointer Exception");
		try {
			String str = null;
			System.out.println(str.length());
		} catch (NullPointerException e) {
			System.out.println("Null pointer exception");
		}

		// Number Format Exception
		System.out.println("Number Format Exception");
		try {
			String str = "abc";
			int num = Integer.parseInt(str);
			System.out.println(num);
		} catch (NumberFormatException e) {
			System.out.println("Number format exception");
		}

		// String Index Out Of Bounds Exception
		System.out.println("String Index Out Of Bounds Exception");
		try {
			String str = "abc";
			char c = str.charAt(4);
			System.out.println(c);
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("String index out of bounds");
		}

		// Illegal Argument Exception
		System.out.println("Illegal Argument Exception");
		try {
			String str = "abc";
			int num = Integer.parseInt(str);
			System.out.println(num);
		} catch (IllegalArgumentException e) {
			System.out.println("Illegal argument exception");
		}
		
		// Array Index Out Of Bounds Exception
        System.out.println("Array Index Out Of Bounds Exception");
        try {
            int[] arr = new int[5];
            arr[6] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");
        }

        // Null Pointer Exception
        System.out.println("Null Pointer Exception");
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception");
        }

        // Number Format Exception
        System.out.println("Number Format Exception");
        try {
            String str = "abc";
            int num = Integer.parseInt(str);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Number format exception");
        }

        // String Index Out Of Bounds Exception
        System.out.println("String Index Out Of Bounds Exception");
        try {
            String str = "abc";
            char c = str.charAt(4);
            System.out.println(c);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String index out of bounds");
        }

        // Illegal Argument Exception
        System.out.println("Illegal Argument Exception");
        try {
            String str = "abc";
            int num = Integer.parseInt(str);
            System.out.println(num);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument exception");
        }

        int x[] = new int[10];
        int y[][] = new int[4][5];

        try {
            System.out.println(y[3]); // Corrected index to avoid ArrayIndexOutOfBoundsException
            System.out.println(x[9]); // Corrected index to avoid ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");
        }

        System.out.println("end");

        // read a file
        File file = new File("studentser.txt");
        try (FileReader fr = new FileReader(file)) {
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.println((char) ch);
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
	}

}

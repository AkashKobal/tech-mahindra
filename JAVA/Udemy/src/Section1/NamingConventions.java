package Section1;

// Class names should be nouns and describe their purpose
class ReverseString {
	// Method names should be verbs, describing what they do
	public String reverse(String input) {
		StringBuilder reversed = new StringBuilder(input);
		return reversed.reverse().toString();
	}
}

// Interface names should be adjectives, often ending in "able"
interface Readable {
	void readData();
}

// A class implementing the Readable interface
class FileReader implements Readable {
	@Override
	public void readData() {
		System.out.println("Reading data from a file...");
	}
}

// Constants should be in uppercase with underscores
class MathConstants {
	public static final double PI = 3.141592653589793;
	public static final int MAX_INT = Integer.MAX_VALUE;
}

public class NamingConventions {
	public static void main(String[] args) {
		// Using ReverseString class
		ReverseString reverser = new ReverseString();
		System.out.println("Reversed: " + reverser.reverse("Java"));

		// Using Readable interface
		Readable reader = new FileReader();
		reader.readData();

		// Using constants
		System.out.println("Value of PI: " + MathConstants.PI);
		System.out.println("Max Integer: " + MathConstants.MAX_INT);
	}
}

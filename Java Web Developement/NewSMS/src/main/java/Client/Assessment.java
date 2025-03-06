package Client;

import java.util.function.BiFunction;

abstract class Shape {
	abstract public double area(int a, int b);

}

class Triangle extends Shape {
	@Override

	public double area(int b, int h) {

		return 0.5 * b * h;
	}
}

public class Assessment {
	// create abstract class shape and override method area()
	// improvise shape to Interface
	// improvise shape to functional interface
	// Replace area() with Function<> functional interface

	public static void main(String[] args) {
		Shape s = new Triangle();
		System.out.println("Area is:" + s.area(4, 6));
		
		 BiFunction<Integer, Integer, Double> triangleArea = (b, h) -> 0.5 * b * h;

	     System.out.println("Area using BiFunction is: " + triangleArea.apply(4, 6));

	}

}

package Section7_OOPS_Inheritance;

public class Main {
	
	public static void main(String[] args) {
		
		Bike bike = new Bike();
		bike.handel = "Short";
		System.out.println("Bike Handel: " + bike.handel);
		
		// inherited vehicle properties from Vehicle class to Bike class
		bike.engine = "4 Stroke";
		bike.wheels = 2;
		System.out.println("Bike Engine: " + bike.engine);
		System.out.println("Bike Wheels: " + bike.wheels);
		
	}

}

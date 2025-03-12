package Section7_OOPS_Inheritance;

public class Vehicle {
	
	public String engine;
	public int wheels;
	
	// using private access modifier to restrict the access of properties of Vehicle class
	// can't access private properties in different class
	// so use public getter and setter methods to access and manipulate private properties
	private int seats;
	private int fuelTank;
	private String lights;
	
	// initialize the properties of Vehicle class is done using constructor
	public Vehicle() {
		engine = "4 Stroke";
		wheels = 4;
		seats = 4;
		fuelTank = 40;
		lights = "LED";
	}
	
//	Constructors can be overloaded, meaning you can have multiple constructors with different parameter lists.
	//	You can have any number of constructors in a class.
	
	// constructor with parameters
	// normal constructor is used to initialize the properties.
	// but parameterized constructor is used to initialize the properties with the values passed as arguments.
	// so we can create multiple objects with different values of properties.
	// value of properties can be changed using constructor.
	public Vehicle(String engine, int wheels, int seats, int fuelTank, String lights) {
	super();
	this.engine = engine;
	this.wheels = wheels;
	this.seats = seats;
	this.fuelTank = fuelTank;
	this.lights = lights;
}

	// generating getter and setter methods for private properties
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getFuelTank() {
		return fuelTank;
	}

	public void setFuelTank(int fuelTank) {
		this.fuelTank = fuelTank;
	}

	public String getLights() {
		return lights;
	}

	public void setLights(String lights) {
		this.lights = lights;
	}

	// toString is used to print value of the base class properties(parent class) which is initialized using non parameterized constructor
	@Override
	public String toString() {
		return "Vehicle [engine=" + engine + ", wheels=" + wheels + ", seats=" + seats + ", fuelTank=" + fuelTank
				+ ", lights=" + lights + "]";
	}
	
	
	
	

}

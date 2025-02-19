package Section7_Oops;


public class Main {
	
	public static void main(String[] args) {
		System.out.println("OOPS Concepts in Java");
		
		Student akash = new Student();
		
		// can access public members in different class, can be  manipulated as well using dot operator or object reference or assigning values 
		System.out.println("Name: " + akash.name);
		System.out.println("Age: " + akash.age);
		System.out.println("Roll No: " + akash.rollNo);
		System.out.println("Branch: " + akash.branch);
		
		// can't to access private members in different class
		// so use public getter and setter methods to access and manipulate private members
		
		System.out.println("Pan No :"+akash.getPanNo());
		System.out.println("Aadhar No :"+akash.getAadharNo());
		
		// can't access dlNo as it is private member and we didnot assigned value to it in Student class
		// so use setter method to assign value to dlNo in different class
		
		akash.setDlNo("DL1234567890");
		
		// use getter method to access value of dlNo in different class
	    System.out.println("DL No :"+akash.getDlNo());
	    
	   
	    
		
	}

}

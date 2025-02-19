package Section7_Oops;

public class InstanceVariable {
	 // instance variables or instant variables :
		// public variables are instant variable or instance members or object members or fields
		// there can be accessed in different class using object reference or dot operator or assigning values
		
	    String nameTest ; // local variable have no default value
//	     System.out.println(nameTest); // error: local variables must be initialized
	    
	    public String strignVariable ; // String instance variable have default value null
	    public int intVariable ; // int instance variable have default value 0
	    public float floatVariable ; // float instance variable have default value 0.0
	    public char charVariable ; // char instance variable have default value null
	    public double doubleVariable ; // double instance variable have default value 0.0
	    public boolean booleanVariable ; // boolean instance variable have default value false
	    
	    public static void main(String[] args) {
			System.out.println("Instance Variables in Java");
			
			InstanceVariable instanceVariable = new InstanceVariable();
			System.out.println("Default value of String instance variable : "+instanceVariable.strignVariable);
			System.out.println("Default value of int instance variable : "+instanceVariable.intVariable);
			System.out.println("Default value of float instance variable : "+instanceVariable.floatVariable);
			System.out.println("Default value of char instance variable : "+instanceVariable.charVariable);
			System.out.println("Default value of double instance variable : "+instanceVariable.doubleVariable);
			System.out.println("Default value of boolean instance variable : "+instanceVariable.booleanVariable);
			
			System.out.println("Default value of local variable : "+instanceVariable.nameTest);
		}
}

package Section7_Oops;

public class Student {
	
	public String name = "Akash";
	public int age = 25;
	public int rollNo = 101;
	public String gender = "Male";
	public String branch = "CSE";
	
	private String panNo = "ABCDE1234F";
	private String aadharNo = "1234 5678 9012";
	
	// use public getter and setter methods to access and manipulate private members in different class
	
	// we assign values to private members (panNo, aadharNo) so no need for setter methods
	// we need getter methods to access values of private members in different class
	
	public String getPanNo() {
		return panNo;
	}


	public String getAadharNo() {
		return aadharNo;
	}


	private String dlNo;

	// we didnot assigned values to dlNo so we need setter method to assign value to dlNo in different class
	// we need getter method to access value of dlNo in different class
	
	public String getDlNo() {
		return dlNo;
	}

	public void setDlNo(String dlNo) {
		this.dlNo = dlNo;
	}
	

}

package User;

public class User {
	private String fname;
	private String lname;
	
	public User() {
		fname = "first";
		lname = "last";
		
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	

}

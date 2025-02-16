package p1;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable{
	private String sid;
	private String sname;
	private String email;
	private String address;
	private int year;
	
	// generate getters and setters
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
	
	public String getSname() {
		return sname;
	}
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(address, email, sid, sname, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(sid, other.sid) && Objects.equals(sname, other.sname) && year == other.year;
	}

	public static void main(String[] args) {
	
		
		
	}

}

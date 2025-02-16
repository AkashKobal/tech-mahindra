package p1;

import java.util.Objects;

public class Courses {
	private String courseid;
	private String coursename;
	private String credit;
	private String ctype;
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	@Override
	public int hashCode() {
		return Objects.hash(courseid, coursename, credit, ctype);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Courses other = (Courses) obj;
		return Objects.equals(courseid, other.courseid) && Objects.equals(coursename, other.coursename)
				&& Objects.equals(credit, other.credit) && Objects.equals(ctype, other.ctype);
	}
	
	
	
	
	
	
	
}

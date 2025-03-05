package Model;

public class Course {
	private int courseid;
	private String coursename;
	private int duration;
	private int fees;
	private String category;
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Course(int courseid, String coursename, int duration, int fees, String category) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.duration = duration;
		this.fees = fees;
		this.category = category;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", coursename=" + coursename + ", duration=" + duration + ", fees="
				+ fees + ", category=" + category + "]";
	}

	
	

}

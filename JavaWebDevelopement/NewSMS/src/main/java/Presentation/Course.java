package Presentation;

public class Course {
	private String courseName;
	private String courseId;
	private int credit;
	
	public Course(String courseName, String courseId, int credit) {
		this.courseName = courseName;
		this.courseId = courseId;
		this.credit = credit;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseId=" + courseId + ", credit=" + credit + "]";
	}
	
	
	
	
	

}

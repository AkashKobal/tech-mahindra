package Model;

import java.util.Objects;

public class TestModel {
	private int testid;
	private String testname;
	
	
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	public String getTestname() {
		return testname;
	}
	public void setTestname(String testname) {
		this.testname = testname;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(testid, testname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestModel other = (TestModel) obj;
		return testid == other.testid && Objects.equals(testname, other.testname);
	}
	
	public TestModel(int testid, String testname) {
		super();
		this.testid = testid;
		this.testname = testname;
	}

}

package Client;

import java.util.Objects;



public class TestFunctionalInterfaceForCollections {
	public class Student{

		private int id;
		private String name;
		private double cgpa;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getCgpa() {
			return cgpa;
		}
		public void setCgpa(double cgpa) {
			this.cgpa = cgpa;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", cgpa=" + cgpa + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(cgpa, id, name);
			return result;
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
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Double.doubleToLongBits(cgpa) == Double.doubleToLongBits(other.cgpa) && id == other.id
					&& Objects.equals(name, other.name);
		}
		private TestFunctionalInterfaceForCollections getEnclosingInstance() {
			return TestFunctionalInterfaceForCollections.this;
		}
		public Student(int id, String name, double cgpa) {
			super();
			this.id = id;
			this.name = name;
			this.cgpa = cgpa;
		}
		
		
		
	}
	
	public static void main(String[] args) {
		
	
	}

}

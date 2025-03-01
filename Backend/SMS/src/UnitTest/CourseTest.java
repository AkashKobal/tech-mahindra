package UnitTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class CourseTest {
	 public static void main(String[] args) {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/techm", "root", "Akash@123");
	            Statement stmt = con.createStatement();
	            int ans = 1;
	            Scanner sc = new Scanner(System.in);

	            do {
	                System.out.println("1. Insert a record ");
	                System.out.println("2. Delete a record ");
	                System.out.println("3. Modify/Edit a record ");
	                System.out.println("4. Display list of records ");
	                System.out.println("Enter your choice:");
	                int ch = sc.nextInt();
	                String courseid, coursename, coursetype;
	                int credit;
	                String query;

	                switch (ch) {
	                    case 1:
	                        System.out.println("Enter course ID:");
	                        courseid = sc.next();
	                        System.out.println("Enter course name:");
	                        coursename = sc.next();
	                        System.out.println("Enter course credit:");
	                        credit = sc.nextInt();
	                        System.out.println("Enter course type:");
	                        coursetype = sc.next();

	                        query = "INSERT INTO course VALUES ('" + courseid + "','" + coursename + "'," + credit + ",'" + coursetype + "')";
	                        stmt.executeUpdate(query);
	                        System.out.println("Record inserted successfully.");
	                        break;

	                    case 2:
	                        System.out.println("Enter course ID to delete:");
	                        courseid = sc.next();
	                        query = "DELETE FROM course WHERE courseid='" + courseid + "'";
	                        stmt.executeUpdate(query);
	                        System.out.println("Record deleted successfully.");
	                        break;

	                    case 3:
	                        PreparedStatement ps;
	                        query = "UPDATE course SET coursename=?, credit=?, coursetype=? WHERE courseid=?";
	                        ps = con.prepareStatement(query);
	                        System.out.println("Enter course ID to update:");
	                        courseid = sc.next();
	                        System.out.println("Enter new course name:");
	                        coursename = sc.next();
	                        System.out.println("Enter new course credit:");
	                        credit = sc.nextInt();
	                        System.out.println("Enter new course type:");
	                        coursetype = sc.next();

	                        ps.setString(1, coursename);
	                        ps.setInt(2, credit);
	                        ps.setString(3, coursetype);
	                        ps.setString(4, courseid);
	                        ps.executeUpdate();
	                        System.out.println("Record updated successfully.");
	                        break;

	                    case 4:
	                        ResultSet rs = stmt.executeQuery("SELECT * FROM course");
	                        System.out.println("Course Records:");
	                        while (rs.next()) {
	                            System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3) + "  " + rs.getString(4));
	                        }
	                        break;

	                    default:
	                        System.out.println("Invalid choice. Please enter a valid option.");
	                }

	                System.out.println("Do you want to perform another operation? (1 for Yes / 0 for No)");
	                ans = sc.nextInt();
	            } while (ans == 1);

	            con.close();
	            sc.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
}
		
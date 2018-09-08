package devloper.MVC;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class LoginProcessHelper {
	
	String url = "jdbc:mysql://localhost:3306/final";
	String username = "root";
	String password = "root";
	String sql = "Select * from student1 WHERE email =? and password =?";

	public boolean checkInfo(String uname, String pass) {
		try {
			System.out.println("bbbbbbbbb......");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, username, password);
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, uname);
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();
			System.out.println("ccccccccc......");
			if (rs.next()) {
				System.out.println("dddddddd......");
				return true;
				
			}

		} catch (Exception e) {
			System.out.println("fffffffff......");
			e.printStackTrace();
		}
		System.out.println("false return......");
		return false;
	}

}

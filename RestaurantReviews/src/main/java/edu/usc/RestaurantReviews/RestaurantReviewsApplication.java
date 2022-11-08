package edu.usc.RestaurantReviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;

@SpringBootApplication
public class RestaurantReviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantReviewsApplication.class, args);
	}

}


@RestController
class Test {
	@GetMapping("/")
	public String msg() {
		return "Test Message: CSCI201 Group Project - RestaurantReviews";
	}
	
	@GetMapping("/table")
	public String table() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
		// Initialize connection, statement, result set
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		String msg = "";
		
		try {
//			//c = DriverManager.getConnection("jdbc:mysql://34.94.218.82:3306/RestaurantReviewsDatabase");
//			c = DriverManager.getConnection("jdbc:mysql://34.94.218.82:3306/RestaurantReviewsDatabase?user=root");
//			s = c.createStatement();
//			s.execute("DROP TABLE IF EXISTS Users;");
//			s.execute("CREATE TABLE Users ( UserID int primary key not null auto_increment, Username varchar(50), Password varchar(50) );");
//			s.execute("INSERT INTO Users (Username, Password) VALUES ('adityak2003', 'pass123');");
//			
//			rs = s.executeQuery("SELECT * FROM Users");
//			
//			// Print out all information
//			while(rs.next()) {
//				msg += "Username: " + rs.getString("Username");
//				msg += "\tPassword: " + rs.getString("Password");
//			}
//			
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//			return e.getMessage();
//		} 
//		finally {
//			// Close all variables
//			try {
//				if(rs != null) rs.close();
//				if(s != null) s.close();
//				if(c != null) c.close();
//			} catch(Exception e) {
//				return e.getMessage();
//			}
//		}
		
		return msg;
	}
}

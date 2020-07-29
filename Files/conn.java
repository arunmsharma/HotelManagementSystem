package hotel.management.system;
import java.sql.*;

public class conn {
	Connection c;
	Statement s;
	
	public conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","AM20$21a");
			
			s = c.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

package util;
import java.sql.Connection;
import java.sql.DriverManager;
public class singletonConnexion{
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema","root","");
			System.out.println("database connected successfuly");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static Connection getConnection() {
		return con;
	}
}
package mvc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() throws SQLException, ClassNotFoundException  {


		Connection conn = null;

		String url = "jdbc:mysql://192.168.0.171:3306/dvdmarketdb";
		String user = "dvdmarket";
		String password = "dvd1234";

		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);

		return conn;
		 }
}

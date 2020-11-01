package foods.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String connectionStr = "jdbc:mysql://localhost:3306/foods";
	private static final String username = "root";
	private static final String password = "1230";
	private static DBConnection instance = new DBConnection();
	
	private Connection conn;
	
	private DBConnection() {
		
	}
	
	public static DBConnection getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
			instance.conn = DriverManager.getConnection(connectionStr, username, password);
			System.out.println("Connection succesfull!!!!!!!!!");
			
			return conn;
		
	}

}

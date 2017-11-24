package edu.aula7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static DBUtil instancia;
	private Connection con;
	
	private DBUtil() { 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/agenda";
			con = DriverManager.getConnection(url, "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static DBUtil getInstance() {
		if (instancia == null) { 
			instancia = new DBUtil();
		}
		return instancia;
	}
	
	public Connection getConnection() { 
		return con;
	}

}

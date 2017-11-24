package edu.aula7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDBSelect {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/agenda";
			Connection con = DriverManager.getConnection(url, "root", "root");
			System.out.println("Conexão bem sucedida");
			Statement stmt = con.createStatement();
			String cmd = "SELECT * FROM contatos";
			ResultSet rs = stmt.executeQuery(cmd);
			while (rs.next()) { 
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				System.out.println("Nome : " + nome + "   Email : " + email);
			}	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

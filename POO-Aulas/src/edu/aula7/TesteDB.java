package edu.aula7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDB {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/agenda";
			Connection con = DriverManager.getConnection(url, "root", "root");
			System.out.println("Conexão bem sucedida");
			
			Statement stmt = con.createStatement();
			String cmd = "INSERT INTO contatos (id, nome, telefone, email, descricao) "
					+ "VALUES (2, 'Carlos', '2222-2222', 'carlos@hotmail.com', '')";
			int i = stmt.executeUpdate(cmd);
			System.out.println("Foram afetados " + i + " registros");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

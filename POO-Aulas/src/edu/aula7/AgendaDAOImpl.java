package edu.aula7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAOImpl implements AgendaDAO {

	@Override
	public void adicionar(Agenda a) {
		try {
			Connection con = DBUtil.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(
					"INSERT INTO contatos " +
					" (id, nome, telefone, email, descricao) " + 
				    "VALUES (?, ?, ?, ?, ?)" );

			stmt.setInt(1, 0);
			stmt.setString(2, a.getNome() );
			stmt.setString(3, a.getTelefone() );
			stmt.setString(4, a.getEmail() );
			stmt.setString(5, "" );
			stmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Agenda> pesquisarPorNome(String nome) {
		List<Agenda> lista = new ArrayList<Agenda>();
		try {
			Connection con = DBUtil.getInstance().getConnection();
			String cmd = "SELECT * FROM contatos WHERE nome like ?";
			PreparedStatement stmt = con.prepareStatement( cmd );
			stmt.setString(1,  "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Agenda a = new Agenda();
				a.setEmail( rs.getString("email") );
				a.setNome(rs.getString("nome") );
				a.setTelefone( rs.getString("telefone") );
				lista.add( a );
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}

package edu.aula7;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class AgendaControl implements TableModel {
	
	private List<Agenda> lista = new ArrayList<Agenda>();
	private AgendaDAO aDao = new AgendaDAOImpl();
	
	public void adicionar(Agenda a) { 
		aDao.adicionar( a );
	}
	
	public List<Agenda> pesquisar(String nome) { 
		lista = aDao.pesquisarPorNome( nome );
		return lista;
	}
	
	public Agenda getItem( int i ) { 
		return lista.get( i );
	}
	
	@Override
	public void addTableModelListener(TableModelListener arg0) {
	}

	@Override
	public Class<?> getColumnClass(int coluna) {
		switch( coluna ) { 
			case 0 : return String.class;
			case 1 : return String.class;
			case 2 : return String.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int coluna) {
		switch( coluna ) { 
			case 0 : return "Nome";
			case 1 : return "Telefone";
			case 2 : return "Email";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Agenda a = lista.get( linha );
		switch( coluna ) { 
			case 0 : return a.getNome();
			case 1 : return a.getTelefone();
			case 2 : return a.getEmail();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}

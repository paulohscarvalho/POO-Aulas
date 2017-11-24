package edu.aula7;

import java.util.List;

public interface AgendaDAO {
	void adicionar(Agenda c);
	List<Agenda> pesquisarPorNome(String nome);
}

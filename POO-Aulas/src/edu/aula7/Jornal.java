package edu.aula7;

import java.util.ArrayList;
import java.util.List;

public class Jornal implements Publicadora {
	List<Assinante> assinantes = new ArrayList<Assinante>();

	@Override
	public void add(Assinante a) {
		assinantes.add( a );
	}

	@Override
	public void remove(Assinante a) {
		assinantes.remove( a );
	}

	@Override
	public void distribuirNoticias(String noticia) {
		for (Assinante a : assinantes) { 
			a.recebeNoticia(noticia);
		}
	}

}

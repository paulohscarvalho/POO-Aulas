package edu.aula7;

public class Empresario implements Assinante {

	private String nome;

	public Empresario(String nome) {
		this.nome = nome;
		
	}
	
	@Override
	public void recebeNoticia(String noticia) {
		System.out.println(nome + " recebeu a noticia - " + noticia);
		
	}

}

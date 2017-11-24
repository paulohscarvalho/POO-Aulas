package edu.aula7;

public class Teste {

	public static void main(String[] args) {
		Jornal estadao = new Jornal();
		Jornal globo = new Jornal();
		Jornal folha = new Jornal();
		Jornal valorEconomico = new Jornal();
		
		Empresario e1 = new Empresario("Roberto Justus");
		Empresario e2 = new Empresario("Eike Baptista");
		Empresario e3 = new Empresario("Edir Macedo");
		Empresario e4 = new Empresario("Valdomiro Santiago");
		FatecZL f = new FatecZL();
		
		
		folha.add( e1 ); // Roberto Justus assinando a Folha
		valorEconomico.add( e1 ); // Roberto Justus assinando o Valor Economico
		
		estadao.add( e2 ); // Eike assinando o Estadão
		valorEconomico.add( e2 ); // Eike assinando o Valor Economico
		
		folha.add( e3 );
		estadao.add( e3 );
		
		globo.add( e4 );
		folha.add( e4 );
		valorEconomico.add( e4 );
		valorEconomico.add( f );
		
		valorEconomico.distribuirNoticias("Walter faz o primeiro milhão");
		folha.distribuirNoticias("Finalmente ele foi preso, LULA segue no camburão para a Papuda");
		estadao.distribuirNoticias("Novo tiroteio na Rocinha, deixa quatro feridos");
		globo.distribuirNoticias("Senado aprova 2ª indiciação de Michel Temer");

	}

}

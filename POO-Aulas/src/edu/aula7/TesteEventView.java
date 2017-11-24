package edu.aula7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TesteEventView implements ActionListener {
	
	private JLabel lblTexto;

	public TesteEventView() {
		JFrame janela = new JFrame("Teste de Evento");
		JPanel painel = new JPanel();
		lblTexto = new JLabel("Teste de pressionamento do botão");
		JButton btnOk = new JButton("Aperte-me");
		
		// ListenerDoBotao ld = new ListenerDoBotao();
		// btnOk.addActionListener( ld );
		btnOk.addActionListener( this );
		
		painel.add(lblTexto);
		painel.add(btnOk);
		janela.setContentPane(painel);
		
		janela.setSize(300, 200);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TesteEventView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lblTexto.setText( "Botão pressionado ... ");
	}

}

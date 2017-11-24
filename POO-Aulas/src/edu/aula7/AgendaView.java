package edu.aula7;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AgendaView implements ActionListener, ListSelectionListener {
	
	private JTextField txtNome = new JTextField();
	private JTextField txtTelefone = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JTable tabela = new JTable();
	private AgendaControl control = new AgendaControl();

	public AgendaView() { 
		JFrame janela = new JFrame("Agenda Telefonica");
		JPanel panPrincipal = new JPanel(new BorderLayout());
		JPanel panBotoes = new JPanel();
		JPanel panForm = new JPanel(new GridLayout(3, 2));
		
		btnSalvar.addActionListener( this );
		btnPesquisar.addActionListener( this );
		
		tabela.setModel( control );
		tabela.getSelectionModel().addListSelectionListener( this );
		
		panBotoes.add(btnSalvar);
		panBotoes.add(btnPesquisar);
		panForm.add(new JLabel("Nome"));
		panForm.add(txtNome);
		panForm.add(new JLabel("Telefone"));
		panForm.add(txtTelefone);
		panForm.add(new JLabel("Email"));
		panForm.add(txtEmail);
		panPrincipal.add(panForm, BorderLayout.NORTH);
		
		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().add(tabela);
		
		panPrincipal.add(scroll, BorderLayout.CENTER);
		panPrincipal.add(panBotoes, BorderLayout.SOUTH);
		janela.setContentPane( panPrincipal );
		janela.setSize(400, 250);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public static void main(String[] args) {
		new AgendaView();
	}
	
	public void agendaToForm(Agenda a) { 
		txtNome.setText( a.getNome() );
		txtTelefone.setText( a.getTelefone() );
		txtEmail.setText( a.getEmail() );
	}
	
	public Agenda formToAgenda() { 
		Agenda a = new Agenda();
		a.setNome(txtNome.getText());
		a.setTelefone(txtTelefone.getText());
		a.setEmail(txtEmail.getText());
		return a;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Salvar".equals(cmd)) {
			control.adicionar( formToAgenda() );	
			tabela.invalidate();
			tabela.revalidate();
			tabela.repaint();
		} else if ("Pesquisar".equals(cmd)) { 
			List<Agenda> lista = control.pesquisar( txtNome.getText());
			if (lista.size() > 0) { 
				Agenda a = lista.get(0);
				agendaToForm(a);
			}
			tabela.invalidate();
			tabela.revalidate();
			tabela.repaint();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Agenda a = control.getItem( tabela.getSelectedRow() );
		agendaToForm(a);
	}
}

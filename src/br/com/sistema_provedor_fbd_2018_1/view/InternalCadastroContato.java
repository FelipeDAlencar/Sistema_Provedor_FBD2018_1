package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public class InternalCadastroContato extends TelaInternal  {
	private JComboBox<String> comboContato;
	private Botao bntSalvar;
	private JFormattedTextField cpfField, dataNascimentoField;
	private JLabel lblTipo;
	private JtextFieldGenerico contatoField;
	private JButton btnNovoContato;
	private JLabel lblResponsvel;
	private JTextField responsavelField;
	private JSeparator separator_1;


	public InternalCadastroContato(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super("Cadastro Contato", telaPrincipal, actionListener);
		setBounds(400, 100, 534, 390);
		getContentPane().setLayout(null);
	}

	@Override
	public void inicializar() throws BusinessException {
		comboContato = new JComboBox<String>();
		comboContato.setBounds(64, 94, 200, 30);
		getContentPane().add(comboContato);
		
		comboContato.addItem("");
		comboContato.addItem("Email");
		comboContato.addItem("Telefone");
		comboContato.addItem("Celular");
		
		JLabel lblContato = new JLabel("Contato:");
		lblContato.setBounds(64, 158, 46, 14);
		getContentPane().add(lblContato);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(64, 69, 100, 14);
		getContentPane().add(lblTipo);
		
		
		contatoField = new JtextFieldGenerico("ABCDEFGHIJLMNOPQRSTUVXZWKYabcdefghijlmnopqrstuvxzwky1234567890.@");
		contatoField.setBounds(64, 181, 200, 30);
		getContentPane().add(contatoField);
		contatoField.setColumns(10);
		
				
		btnNovoContato = new JButton("Salvar");
		btnNovoContato.setBounds(64, 311, 109, 39);
		getContentPane().add(btnNovoContato);
		
		

		JSeparator separator = new JSeparator();
		separator.setBounds(827, 433, 46, -158);
		getContentPane().add(separator);
		
		lblResponsvel = new JLabel("Respons\u00E1vel:");
		lblResponsvel.setBounds(64, 239, 92, 14);
		getContentPane().add(lblResponsvel);
		
		
		responsavelField = new JTextField();
		responsavelField.setBounds(64, 264, 200, 30);
		getContentPane().add(responsavelField);
		responsavelField.setColumns(10);
		
		
	}

	public JComboBox<String> getComboContato() {
		return comboContato;
	}

	public Botao getBntSalvar() {
		return bntSalvar;
	}

	public JFormattedTextField getCpfField() {
		return cpfField;
	}

	public JFormattedTextField getDataNascimentoField() {
		return dataNascimentoField;
	}

	public JLabel getLblTipo() {
		return lblTipo;
	}

	public JtextFieldGenerico getContatoField() {
		return contatoField;
	}

	public JButton getBtnSalvar() {
		return btnNovoContato;
	}

	public JLabel getLblResponsvel() {
		return lblResponsvel;
	}

	public JTextField getResponsavelField() {
		return responsavelField;
	}

	public JSeparator getSeparator_1() {
		return separator_1;
	}
	
	

}

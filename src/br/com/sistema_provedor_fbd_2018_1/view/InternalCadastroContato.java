package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

@SuppressWarnings("serial")
public class InternalCadastroContato extends TelaInternal  {
	private JComboBox<String> comboContato;
	private JFormattedTextField cpfField, dataNascimentoField;
	private JLabel lblTipo;
	private JtextFieldGenerico contatoField;
	private Botao btnNovoContato;
	private JLabel lblResponsvel;
	private JTextField responsavelField;
	private JSeparator separator_1;


	public InternalCadastroContato(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super("Cadastro Contato", telaPrincipal, actionListener);
		setBounds(530, 160, 300, 260);
		getContentPane().setLayout(null);
	}

	@Override
	public void inicializar() throws BusinessException {
		comboContato = new JComboBox<String>();
		comboContato.setBounds(39, 48, 100, 30);
		getContentPane().add(comboContato);
		
		comboContato.addItem("");
		comboContato.addItem("Email");
		comboContato.addItem("Telefone");
		comboContato.addItem("Celular");
		
		JLabel lblContato = new JLabel("Contato:");
		lblContato.setBounds(39, 89, 46, 14);
		getContentPane().add(lblContato);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(39, 23, 100, 14);
		getContentPane().add(lblTipo);
		
		
		contatoField = new JtextFieldGenerico("ABCDEFGHIJLMNOPQRSTUVXZWKYabcdefghijlmnopqrstuvxzwky1234567890.@");
		contatoField.setBounds(39, 114, 218, 30);
		getContentPane().add(contatoField);
		contatoField.setColumns(10);
		
				
		btnNovoContato = new Botao("resource/imagens/botoes/bnt-salvar.png", "Salvar");
		btnNovoContato.setBounds(148, 155, 109, 40);
		getContentPane().add(btnNovoContato);
		
		

		JSeparator separator = new JSeparator();
		separator.setBounds(827, 433, 46, -158);
		getContentPane().add(separator);
		
		lblResponsvel = new JLabel("Respons\u00E1vel:");
		lblResponsvel.setBounds(157, 23, 92, 14);
		getContentPane().add(lblResponsvel);
		
		
		responsavelField = new JTextField();
		responsavelField.setBounds(157, 48, 100, 30);
		getContentPane().add(responsavelField);
		responsavelField.setColumns(10);
		
		
	}

	public JComboBox<String> getComboContato() {
		return comboContato;
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

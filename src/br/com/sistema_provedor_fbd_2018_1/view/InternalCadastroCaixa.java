package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class InternalCadastroCaixa extends TelaInternal {
	private JTextField nomeField;
	private JTextField latitudeField;
	private JTextField longitudeField;
	private JButton btnCadastrar;
	private JtextFieldGenerico cepField;

	public InternalCadastroCaixa(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Cadastro de Caixas", telaPrincipal, actionListener);
		setBounds(300, 100, 800, 400);
		getContentPane().setLayout(null);

	}

	@Override
	public void inicializar() throws BusinessException {
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(47, 65, 46, 14);
		getContentPane().add(lblNome);

		nomeField = new JTextField();
		nomeField.setBounds(47, 90, 156, 34);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Latitude:");
		lblNewLabel.setBounds(285, 65, 67, 14);
		getContentPane().add(lblNewLabel);

		latitudeField = new JTextField();
		latitudeField.setBounds(285, 90, 191, 34);
		getContentPane().add(latitudeField);
		latitudeField.setColumns(10);

		JLabel lblLongitude = new JLabel("Longitude:");
		lblLongitude.setBounds(570, 65, 102, 14);
		getContentPane().add(lblLongitude);

		longitudeField = new JTextField();
		longitudeField.setBounds(570, 90, 220, 34);
		getContentPane().add(longitudeField);
		longitudeField.setColumns(10);

		btnCadastrar = new JButton("Cadastrar Caixa");
		btnCadastrar.setBounds(659, 244, 131, 23);
		getContentPane().add(btnCadastrar);
		
		
		
		JLabel lblCidade = new JLabel("CEP:");
		lblCidade.setBounds(47, 177, 46, 14);
		getContentPane().add(lblCidade);
		
		cepField = new JtextFieldGenerico("1234567890.");
		cepField.setBounds(47, 202, 156, 34);
		getContentPane().add(cepField);
		cepField.setColumns(10);

	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public JTextField getLatitudeField() {
		return latitudeField;
	}

	public JTextField getLongitudeField() {
		return longitudeField;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JTextField getCepField() {
		return cepField;
	}
	
	
	
	
}

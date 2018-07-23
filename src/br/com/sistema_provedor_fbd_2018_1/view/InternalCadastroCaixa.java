package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class InternalCadastroCaixa extends TelaInternal {
	private JTextField nomeField;
	private JTextField latitudeField;
	private JTextField longitudeField;
	private JButton btnCadastrar;
	private JComboBox<String> cidadeCombo;

	public InternalCadastroCaixa(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Cadastro de Caixas", telaPrincipal, actionListener);
		setBounds(400, 100, 550, 400);
		getContentPane().setLayout(null);

	}

	@Override
	public void inicializar() throws BusinessException {
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(47, 65, 46, 14);
		getContentPane().add(lblNome);

		nomeField = new JTextField();
		nomeField.setBounds(47, 90, 228, 34);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Latitude:");
		lblNewLabel.setBounds(47, 156, 67, 14);
		getContentPane().add(lblNewLabel);

		latitudeField = new JTextField();
		latitudeField.setBounds(47, 183, 190, 34);
		getContentPane().add(latitudeField);
		latitudeField.setColumns(10);

		JLabel lblLongitude = new JLabel("Longitude:");
		lblLongitude.setBounds(299, 156, 102, 14);
		getContentPane().add(lblLongitude);

		longitudeField = new JTextField();
		longitudeField.setBounds(299, 183, 190, 34);
		getContentPane().add(longitudeField);
		longitudeField.setColumns(10);

		btnCadastrar = new JButton("Cadastrar Caixa");
		btnCadastrar.setBounds(358, 260, 131, 40);
		getContentPane().add(btnCadastrar);
		
		
		
		JLabel lblCidade = new JLabel("CEP:");
		lblCidade.setBounds(328, 65, 46, 14);
		getContentPane().add(lblCidade);
		
		carregarCidades();
		cidadeCombo.setBounds(328, 90, 161, 34);
		getContentPane().add(cidadeCombo);

	}
	
	private void carregarCidades() throws BusinessException {
		List<Cidade> cidadesList = new ArrayList<>();
		cidadeCombo = new JComboBox<>();
		Fachada fachada = new Fachada();
		cidadesList = fachada.listarTodosCidades();
		for (Cidade cidade : cidadesList) {
			cidadeCombo.addItem(cidade.getNome());
		}
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

	public JComboBox<String> getCidadeCombo() {
		return cidadeCombo;
	}
	
	
	
	
}

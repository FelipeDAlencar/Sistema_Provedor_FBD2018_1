package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InternalCadastroCidade extends TelaInternal {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomeField;
	private JTextField estadoField;
	private JTextField cepField;
	private JButton btnAdd;

	public InternalCadastroCidade(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Cadastro de Cidades", telaPrincipal, actionListener);
		setBounds(150, 50, 1050, 500);
		getContentPane().setLayout(null);

	}

	@Override
	public void inicializar() throws BusinessException {
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(52, 68, 46, 14);
		getContentPane().add(lblNome);

		nomeField = new JTextField();
		nomeField.setBounds(52, 93, 218, 31);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(394, 68, 46, 14);
		getContentPane().add(lblEstado);

		estadoField = new JTextField();
		estadoField.setBounds(394, 93, 46, 31);
		getContentPane().add(estadoField);
		estadoField.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(615, 68, 46, 14);
		getContentPane().add(lblCep);

		cepField = new JTextField();
		cepField.setBounds(615, 93, 181, 28);
		getContentPane().add(cepField);
		cepField.setColumns(10);

		btnAdd = new JButton("Cadastrar Cidade");
		btnAdd.setBounds(643, 374, 153, 42);
		getContentPane().add(btnAdd);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public JTextField getEstadoField() {
		return estadoField;
	}

	public JTextField getCepField() {
		return cepField;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}
	 
}

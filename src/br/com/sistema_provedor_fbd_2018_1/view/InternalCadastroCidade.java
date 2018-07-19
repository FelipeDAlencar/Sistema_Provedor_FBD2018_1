package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.text.ParseException;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class InternalCadastroCidade extends TelaInternal {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomeField;
	private JFormattedTextField estadoField;
	private JTextField cepField;
	private JButton btnAdd;

	public InternalCadastroCidade(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Cadastro de Cidades", telaPrincipal, actionListener);
		setBounds(300, 100, 800, 400);
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

		estadoField = new JFormattedTextField();
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

		try {
			estadoField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("AA")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

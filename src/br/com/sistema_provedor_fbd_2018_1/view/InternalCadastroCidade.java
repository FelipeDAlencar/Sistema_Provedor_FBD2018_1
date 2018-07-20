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
	
	private static final long serialVersionUID = 1L;
	private JTextField nomeField;
	private JFormattedTextField estadoField;
	private JTextField cepField;
	private JButton btnAdd;

	public InternalCadastroCidade(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Cadastro de Cidades", telaPrincipal, actionListener);
		setBounds(480, 150, 400, 300);
		getContentPane().setLayout(null);

	}

	@Override
	public void inicializar() throws BusinessException {
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(60, 40, 46, 14);
		getContentPane().add(lblNome);

		nomeField = new JTextField();
		nomeField.setBounds(60, 65, 270, 31);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(60, 117, 46, 14);
		getContentPane().add(lblEstado);

		estadoField = new JFormattedTextField();
		estadoField.setBounds(60, 142, 46, 31);
		getContentPane().add(estadoField);
		estadoField.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(149, 117, 46, 14);
		getContentPane().add(lblCep);

		cepField = new JTextField();
		cepField.setBounds(149, 143, 181, 28);
		getContentPane().add(cepField);
		cepField.setColumns(10);
		
		btnAdd = new JButton("Adicionar Cidade");
		btnAdd.setBounds(200, 203, 130, 40);
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

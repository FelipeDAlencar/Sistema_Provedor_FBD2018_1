package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.text.ParseException;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionEvent;

public class InternalCadastroAtendimentos extends TelaInternal {
	private JtextFieldGenerico cpfCliente;
	private JTextField motivoField;
	private JTextField protocoloField;
	private Botao btnSalvar;
	private JLabel lblDataDeAtendimento;
	private JtextFieldGenerico dataField;

	public InternalCadastroAtendimentos(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super("Inserir Atendimento", telaPrincipal, actionListener);
		setBounds(480, 150, 465, 296);
		getContentPane().setLayout(null);

	}

	@Override
	public void inicializar() throws BusinessException {
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 25, 46, 14);
		getContentPane().add(lblCliente);

		cpfCliente = new JtextFieldGenerico("1234567890");
		cpfCliente.setBounds(10, 50, 183, 30);
		getContentPane().add(cpfCliente);
		cpfCliente.setColumns(10);
		
		try {
			cpfCliente.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblMotico = new JLabel("Motivo");
		lblMotico.setBounds(10, 91, 46, 14);
		getContentPane().add(lblMotico);

		motivoField = new JTextField();
		motivoField.setBounds(10, 121, 183, 30);
		getContentPane().add(motivoField);
		motivoField.setColumns(10);

		JLabel lblProtocolo = new JLabel("Protocolo:");
		lblProtocolo.setBounds(234, 25, 76, 14);
		getContentPane().add(lblProtocolo);

		protocoloField = new JTextField();
		protocoloField.setBounds(234, 50, 183, 30);
		getContentPane().add(protocoloField);
		protocoloField.setColumns(10);

		btnSalvar = new Botao("", "Salvar");
		btnSalvar.setBounds(314, 201, 103, 40);
		getContentPane().add(btnSalvar);
		
		lblDataDeAtendimento = new JLabel("Data de atendimento:");
		lblDataDeAtendimento.setBounds(234, 91, 152, 14);
		getContentPane().add(lblDataDeAtendimento);
		
		dataField = new JtextFieldGenerico("1234567890");
		dataField.setBounds(234, 121, 183, 30);
		getContentPane().add(dataField);
		dataField.setColumns(10);
		
		try {
			dataField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public JTextField getCpfCliente() {
		return cpfCliente;
	}

	public JTextField getMotivoField() {
		return motivoField;
	}

	public JTextField getProtocoloField() {
		return protocoloField;
	}

	public Botao getBtnSalvar() {
		return btnSalvar;
	}

	public JLabel getLblDataDeAtendimento() {
		return lblDataDeAtendimento;
	}

	public JtextFieldGenerico getDataField() {
		return dataField;
	}
	
	

}

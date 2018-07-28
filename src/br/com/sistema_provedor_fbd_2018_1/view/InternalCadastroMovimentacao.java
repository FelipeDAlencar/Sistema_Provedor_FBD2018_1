package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.text.ParseException;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class InternalCadastroMovimentacao extends TelaInternal {
	private JtextFieldGenerico valorField, dataMovimentacaoField;
	private Botao btnSalvar;
	private JTextField descricaoField;
	private JComboBox<String> tipocomboBox;
	public InternalCadastroMovimentacao(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
			super("Cadastro de Movimentações", telaPrincipal, actionListener);
			setBounds(500, 50, 391, 506);
			getContentPane().setLayout(null);
			

	}

	@Override
	public void inicializar() throws BusinessException {
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(46, 60, 81, 14);
		getContentPane().add(lblDescrio);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(46, 205, 46, 14);
		getContentPane().add(lblValor);
		
		valorField = new JtextFieldGenerico("1234567890.");
		valorField.setBounds(46, 230, 232, 30);
		getContentPane().add(valorField);
		valorField.setColumns(10);
		
		JLabel lblDataDeMovimentao = new JLabel("Data de Movimenta\u00E7\u00E3o:");
		lblDataDeMovimentao.setBounds(46, 139, 114, 14);
		getContentPane().add(lblDataDeMovimentao);
		
		dataMovimentacaoField = new JtextFieldGenerico("1234567890");
		dataMovimentacaoField.setBounds(46, 164, 232, 30);
		getContentPane().add(dataMovimentacaoField);
		dataMovimentacaoField.setColumns(10);
		
		try {
			dataMovimentacaoField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		btnSalvar = new Botao("","Salvar");
		btnSalvar.setBounds(46, 418, 107, 40);
		getContentPane().add(btnSalvar);
		
		descricaoField = new JTextField();
		descricaoField.setBounds(46, 85, 232, 30);
		getContentPane().add(descricaoField);
		descricaoField.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(46, 281, 46, 14);
		getContentPane().add(lblTipo);
		
		tipocomboBox = new JComboBox();
		tipocomboBox.setBounds(46, 311, 232, 30);
		getContentPane().add(tipocomboBox);
		
		tipocomboBox.addItem("Entrada");
		tipocomboBox.addItem("Saída");
		
		
	}

	
	public JTextField getValorField() {
		return valorField;
	}

	public JTextField getDataMovimentacaoField() {
		return dataMovimentacaoField;
	}

	public Botao getBtnSalvar() {
		return btnSalvar;
	}

	public JTextField getDescricaoField() {
		return descricaoField;
	}

	public JComboBox<String> getTipocomboBox() {
		return tipocomboBox;
	}
	

	
}

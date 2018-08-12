package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class InternalCadastroMovimentacao extends TelaInternal {
	private JtextFieldGenerico valorField;
	private JDateChooser dataMovimentacaoField;
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
		
		dataMovimentacaoField = new JDateChooser();
		dataMovimentacaoField.setBounds(46, 164, 232, 30);
		getContentPane().add(dataMovimentacaoField);
		
		
		
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
		
		tipocomboBox.addItem("Entrada");
		tipocomboBox.addItem("Saída");
		
		
	}

	
	public JTextField getValorField() {
		return valorField;
	}

	public JDateChooser getDataMovimentacaoField() {
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

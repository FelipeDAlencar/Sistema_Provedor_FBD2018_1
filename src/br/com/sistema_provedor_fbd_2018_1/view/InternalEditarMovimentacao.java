package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class InternalEditarMovimentacao extends InternalCadastroMovimentacao {
	private JComboBox situacaoComboBox;
	public InternalEditarMovimentacao(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super(telaPrincipal, actionListener);
		getBtnSalvar().setLocation(46, 426);
		
		JLabel lblSituacao = new JLabel("Situacao:");
		lblSituacao.setBounds(46, 352, 46, 14);
		getContentPane().add(lblSituacao);
		
		situacaoComboBox = new JComboBox();
		situacaoComboBox.setBounds(46, 377, 232, 30);
		getContentPane().add(situacaoComboBox);
		
		situacaoComboBox.addItem("Aguardando pagamento");
		situacaoComboBox.addItem("Pago");
		situacaoComboBox.addItem("Cancelado");

	}
	public JComboBox getSituacaoComboBox() {
		return situacaoComboBox;
	}
	

}

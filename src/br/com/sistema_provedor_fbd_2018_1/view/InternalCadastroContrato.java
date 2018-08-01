package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.text.ParseException;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class InternalCadastroContrato extends TelaInternal {
	private JtextFieldGenerico valorInstalacaoField, valorMensalField, NumeroParcelasField, dataVecimentoField;

	private JTextField loginField;
	private JTextField senhaField;

	private Botao btnSalvar;
	private JLabel lblDataVencimento;

	public InternalCadastroContrato(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super("Inserir Contrato", telaPrincipal, actionListener);
		setBounds(400, 100, 600, 400);
		getContentPane().setLayout(null);

	}

	@Override
	public void inicializar() throws BusinessException {

		JLabel lblValorDaInstalao = new JLabel("Valor da Instala\u00E7\u00E3o:");
		lblValorDaInstalao.setBounds(25, 47, 107, 14);
		getContentPane().add(lblValorDaInstalao);

		valorInstalacaoField = new JtextFieldGenerico("1234567890.");
		valorInstalacaoField.setBounds(25, 71, 203, 30);
		getContentPane().add(valorInstalacaoField);
		valorInstalacaoField.setColumns(10);

		JLabel lblValorMensal = new JLabel("Valor Mensal:");
		lblValorMensal.setBounds(25, 112, 84, 14);
		getContentPane().add(lblValorMensal);

		valorMensalField = new JtextFieldGenerico("1234567890.");
		valorMensalField.setBounds(25, 137, 203, 30);
		getContentPane().add(valorMensalField);
		valorMensalField.setColumns(10);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(347, 47, 46, 14);
		getContentPane().add(lblLogin);

		loginField = new JTextField();
		loginField.setBounds(347, 71, 203, 30);
		getContentPane().add(loginField);
		loginField.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(347, 112, 46, 14);
		getContentPane().add(lblSenha);

		senhaField = new JTextField();
		senhaField.setBounds(347, 137, 203, 30);
		getContentPane().add(senhaField);
		senhaField.setColumns(10);

		JLabel lblNmeroDeParcelas = new JLabel("N\u00FAmero de Parcelas:");
		lblNmeroDeParcelas.setBounds(25, 178, 125, 14);
		getContentPane().add(lblNmeroDeParcelas);

		NumeroParcelasField = new JtextFieldGenerico("1234567890");
		NumeroParcelasField.setBounds(25, 203, 203, 30);
		getContentPane().add(NumeroParcelasField);
		NumeroParcelasField.setColumns(10);

		btnSalvar = new Botao("", "Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvar.setBounds(443, 262, 107, 40);
		getContentPane().add(btnSalvar);

		lblDataVencimento = new JLabel("Data Vencimento:");
		lblDataVencimento.setBounds(347, 178, 112, 14);
		getContentPane().add(lblDataVencimento);

		dataVecimentoField = new JtextFieldGenerico("1234567890.");;
		dataVecimentoField.setBounds(347, 203, 203, 30);
		getContentPane().add(dataVecimentoField);
		dataVecimentoField.setColumns(10);
		setVisible(false);
		
		try {
			dataVecimentoField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}

	public JTextField getValorInstalacaoField() {
		return valorInstalacaoField;
	}

	public JTextField getValorMensalField() {
		return valorMensalField;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public JTextField getSenhaField() {
		return senhaField;
	}

	public JTextField getDataVencimentoField() {
		return dataVecimentoField;
	}

	public JTextField getNumeroParcelasField() {
		return NumeroParcelasField;
	}

	public Botao getBtnSalvar() {
		return btnSalvar;
	}

}

package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.text.ParseException;

import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class InternalCadastroContrato extends TelaInternal {
	private JtextFieldGenerico valorInstalacaoField, valorMensalField, NumeroParcelasField, dataVecimentoField;
	private Botao btnSalvar;
	private JLabel lblDataVencimento;
	private JComboBox<String> servicoCombo;

	public InternalCadastroContrato(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super("Inserir Contrato", telaPrincipal, actionListener);
		setBounds(430, 150, 550, 300);
		getContentPane().setLayout(null);

	}

	@Override
	public void inicializar() throws BusinessException {

		JLabel lblValorDaInstalao = new JLabel("Valor da Instala\u00E7\u00E3o:");
		lblValorDaInstalao.setBounds(41, 85, 142, 14);
		getContentPane().add(lblValorDaInstalao);

		valorInstalacaoField = new JtextFieldGenerico("1234567890.");
		valorInstalacaoField.setBounds(41, 110, 203, 30);
		getContentPane().add(valorInstalacaoField);
		valorInstalacaoField.setColumns(10);

		JLabel lblValorMensal = new JLabel("Valor Mensal:");
		lblValorMensal.setBounds(289, 85, 84, 14);
		getContentPane().add(lblValorMensal);

		valorMensalField = new JtextFieldGenerico("1234567890.");
		valorMensalField.setBounds(289, 110, 203, 30);
		getContentPane().add(valorMensalField);
		valorMensalField.setColumns(10);

		JLabel lblNmeroDeParcelas = new JLabel("N\u00FAmero de Parcelas:");
		lblNmeroDeParcelas.setBounds(41, 151, 125, 14);
		getContentPane().add(lblNmeroDeParcelas);

		NumeroParcelasField = new JtextFieldGenerico("1234567890");
		NumeroParcelasField.setBounds(41, 176, 203, 30);
		getContentPane().add(NumeroParcelasField);
		NumeroParcelasField.setColumns(10);

		btnSalvar = new Botao("", "Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvar.setBounds(385, 219, 107, 40);
		getContentPane().add(btnSalvar);

		lblDataVencimento = new JLabel("Data de Instala\u00E7\u00E3o:");
		lblDataVencimento.setBounds(289, 151, 112, 14);
		getContentPane().add(lblDataVencimento);

		dataVecimentoField = new JtextFieldGenerico("1234567890.");;
		dataVecimentoField.setBounds(289, 176, 203, 30);
		getContentPane().add(dataVecimentoField);
		dataVecimentoField.setColumns(10);
		setVisible(false);
		
		try {
			dataVecimentoField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
			
			JLabel lblServio = new JLabel("Servi\u00E7o:");
			lblServio.setBounds(41, 11, 98, 14);
			getContentPane().add(lblServio);
			
			servicoCombo = new JComboBox<>();
			servicoCombo.setBounds(41, 36, 451, 30);
			getContentPane().add(servicoCombo);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
	

	}
	public JtextFieldGenerico getDataVecimentoField() {
		return dataVecimentoField;
	}

	public JLabel getLblDataVencimento() {
		return lblDataVencimento;
	}

	public JTextField getValorInstalacaoField() {
		return valorInstalacaoField;
	}

	public JTextField getValorMensalField() {
		return valorMensalField;
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

	public JComboBox<String> getServicoCombo() {
		return servicoCombo;
	}
	
	
}

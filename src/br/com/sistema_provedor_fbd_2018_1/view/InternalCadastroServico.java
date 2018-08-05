package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class InternalCadastroServico extends TelaInternal {
	private JtextFieldGenerico downloadField, uploadField;
	private JTextField servicoField;
	private Botao btnInserirServio;

	public InternalCadastroServico(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super("Novo Serviço", telaPrincipal, actionListener);
		setBounds(480, 150, 400, 300);
		getContentPane().setLayout(null);

	}

	@Override
	public void inicializar() throws BusinessException {
		JLabel lblServio = new JLabel("Servi\u00E7o:");
		lblServio.setBounds(50, 34, 46, 14);
		getContentPane().add(lblServio);

		servicoField = new JFormattedTextField();
		servicoField.setBounds(50, 59, 281, 31);
		getContentPane().add(servicoField);
		servicoField.setColumns(10);

		JLabel lblDownload = new JLabel("Download:");
		lblDownload.setBounds(50, 124, 66, 14);
		getContentPane().add(lblDownload);

		downloadField = new JtextFieldGenerico("1234567890,");
		downloadField.setText("");
		downloadField.setBounds(50, 149, 122, 31);
		getContentPane().add(downloadField);
		downloadField.setColumns(10);

		JLabel lblUpload = new JLabel("Upload:");
		lblUpload.setBounds(209, 124, 46, 14);
		getContentPane().add(lblUpload);

		uploadField = new JtextFieldGenerico("''1234567890");
		uploadField.setBounds(209, 149, 122, 31);
		getContentPane().add(uploadField);
		uploadField.setColumns(10);

		btnInserirServio = new Botao("resource/imagens/botoes/bnt-salvar.png", "Salvar");
		btnInserirServio.setBounds(217, 211, 114, 40);
		getContentPane().add(btnInserirServio);

	}

	public JTextField getServicoField() {
		return servicoField;
	}

	public JTextField getDownloadField() {
		return downloadField;
	}

	public JTextField getUploadField() {
		return uploadField;
	}

	public JButton getBtnInserirServio() {
		return btnInserirServio;
	}

}

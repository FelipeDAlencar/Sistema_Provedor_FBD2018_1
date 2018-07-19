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
	private JButton btnInserirServio;

	public InternalCadastroServico(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super("Serviço", telaPrincipal, actionListener);

		setBounds(300, 100, 800, 400);
		getContentPane().setLayout(null);

	}

	@Override
	public void inicializar() throws BusinessException {
		JLabel lblServio = new JLabel("Servi\u00E7o:");
		lblServio.setBounds(58, 63, 46, 14);
		getContentPane().add(lblServio);

		servicoField = new JFormattedTextField();
		servicoField.setBounds(58, 88, 148, 31);
		getContentPane().add(servicoField);
		servicoField.setColumns(10);

		JLabel lblDownload = new JLabel("Download:");
		lblDownload.setBounds(349, 63, 66, 14);
		getContentPane().add(lblDownload);

		downloadField = new JtextFieldGenerico("''1234567890");
		downloadField.setText("");
		downloadField.setBounds(349, 88, 106, 31);
		getContentPane().add(downloadField);
		downloadField.setColumns(10);

		JLabel lblUpload = new JLabel("Upload:");
		lblUpload.setBounds(579, 63, 46, 14);
		getContentPane().add(lblUpload);

		uploadField = new JtextFieldGenerico("''1234567890");
		uploadField.setBounds(579, 88, 86, 31);
		getContentPane().add(uploadField);
		uploadField.setColumns(10);

		btnInserirServio = new JButton("Inserir servi\u00E7o");
		btnInserirServio.setBounds(551, 165, 114, 31);
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

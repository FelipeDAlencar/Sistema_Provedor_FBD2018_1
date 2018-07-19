package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class InternalCadastroConcentrador extends TelaInternal {

	private JTextField nomeFild;
	private JTextField LoginFild;
	private JPasswordField senhaField;
	private JtextFieldGenerico ipFild, cepField;
	private JButton btnAdicionar;

	public InternalCadastroConcentrador(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super("Cadastro de Concentrador", telaPrincipal, actionListener);
		setBounds(300, 100, 800, 400);
		getContentPane().setLayout(null);

		

	}

	@Override
	public void inicializar() throws BusinessException {
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(55, 64, 105, 14);
		getContentPane().add(lblNome);

		nomeFild = new JTextField();
		nomeFild.setBounds(55, 89, 365, 29);
		getContentPane().add(nomeFild);
		nomeFild.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(55, 155, 46, 14);
		getContentPane().add(lblLogin);

		LoginFild = new JTextField();
		LoginFild.setToolTipText("Login");
		LoginFild.setBounds(55, 180, 141, 29);
		getContentPane().add(LoginFild);
		LoginFild.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(246, 155, 46, 14);
		getContentPane().add(lblSenha);

		senhaField = new JPasswordField();
		senhaField.setBounds(246, 180, 174, 29);
		getContentPane().add(senhaField);

		JLabel lblNewLabel_1 = new JLabel("IP:");
		lblNewLabel_1.setBounds(470, 64, 46, 14);
		getContentPane().add(lblNewLabel_1);

		ipFild = new JtextFieldGenerico(".1234567890");
		ipFild.setBounds(470, 89, 229, 29);
		getContentPane().add(ipFild);
		ipFild.setColumns(10);
		ipFild.setMaximoCaracteres(11);

		cepField = new JtextFieldGenerico("1234567890.");
		cepField.setBounds(470, 180, 229, 29);
		getContentPane().add(cepField);

		JLabel lblNewLabel_2 = new JLabel("CEP:");
		lblNewLabel_2.setBounds(470, 155, 46, 14);
		getContentPane().add(lblNewLabel_2);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(610, 272, 89, 29);
		getContentPane().add(btnAdicionar);

	}


	public JTextField getNomeFild() {
		return nomeFild;
	}

	public JTextField getLoginFild() {
		return LoginFild;
	}

	public JPasswordField getSenhaField() {
		return senhaField;
	}

	public JTextField getIpFild() {
		return ipFild;
	}


	
	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}

	public JtextFieldGenerico getCepField() {
		return cepField;
	}
	


	
	
}

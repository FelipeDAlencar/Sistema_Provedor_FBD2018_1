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

	private JTextField nomeField;
	private JTextField LoginField;
	private JPasswordField senhaField;
	private JtextFieldGenerico ipField;
	private JComboBox<String> cidadesCombo;
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

		nomeField = new JTextField();
		nomeField.setBounds(55, 89, 365, 29);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(55, 155, 46, 14);
		getContentPane().add(lblLogin);

		LoginField = new JTextField();
		LoginField.setToolTipText("Login");
		LoginField.setBounds(55, 180, 141, 29);
		getContentPane().add(LoginField);
		LoginField.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(246, 155, 46, 14);
		getContentPane().add(lblSenha);

		senhaField = new JPasswordField();
		senhaField.setBounds(246, 180, 174, 29);
		getContentPane().add(senhaField);

		JLabel lblNewLabel_1 = new JLabel("IP:");
		lblNewLabel_1.setBounds(470, 64, 46, 14);
		getContentPane().add(lblNewLabel_1);

		ipField = new JtextFieldGenerico(".1234567890");
		ipField.setBounds(470, 89, 229, 29);
		getContentPane().add(ipField);
		ipField.setColumns(10);
		ipField.setMaximoCaracteres(15);

		carregarCidades();
		cidadesCombo.setBounds(470, 180, 229, 29);
		getContentPane().add(cidadesCombo);

		JLabel lblNewLabel_2 = new JLabel("Cidade:");
		lblNewLabel_2.setBounds(470, 155, 100, 14);
		getContentPane().add(lblNewLabel_2);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(610, 272, 89, 40);
		getContentPane().add(btnAdicionar);

	}
	
	private void carregarCidades() throws BusinessException {
		List<Cidade> cidadesList = new ArrayList<>();
		cidadesCombo = new JComboBox<>();
		Fachada fachada = new Fachada();
		cidadesList = fachada.listarTodosCidades();
		for (Cidade cidade : cidadesList) {
			cidadesCombo.addItem(cidade.getNome());
		}
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public JTextField getLoginField() {
		return LoginField;
	}

	public JPasswordField getSenhaField() {
		return senhaField;
	}

	public JtextFieldGenerico getIpField() {
		return ipField;
	}

	public JComboBox<String> getCidadesCombo() {
		return cidadesCombo;
	}

	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}
	
	

	
	
}

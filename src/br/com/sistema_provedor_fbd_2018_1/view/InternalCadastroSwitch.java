package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.entidade.Caixa;
import br.com.sistema_provedor_fbd_2018_1.entidade.Concentrador;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class InternalCadastroSwitch extends TelaInternal {
	
	private JTextField nomeField;
	private JTextField LoginField;
	private JPasswordField senhaField;
	private JtextFieldGenerico ipField, numeroPortasField;
	private JComboBox<String> concentradorCombo;
	private JComboBox<String> caixaCombo;
	private JButton btnAdicionar;
	private Fachada fachada;

	public InternalCadastroSwitch(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super("Cadastro de Switch", telaPrincipal, actionListener);
		setBounds(330, 100, 690, 400);
		getContentPane().setLayout(null);
		fachada = new Fachada();
		

	}

	@Override
	public void inicializar() throws BusinessException {
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(55, 40, 105, 14);
		getContentPane().add(lblNome);

		nomeField = new JTextField();
		nomeField.setBounds(55, 65, 277, 29);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(55, 124, 46, 14);
		getContentPane().add(lblLogin);

		LoginField = new JTextField();
		LoginField.setToolTipText("Login");
		LoginField.setBounds(55, 149, 141, 29);
		getContentPane().add(LoginField);
		LoginField.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(246, 124, 46, 14);
		getContentPane().add(lblSenha);

		senhaField = new JPasswordField();
		senhaField.setBounds(246, 149, 174, 29);
		getContentPane().add(senhaField);

		JLabel lblNewLabel_1 = new JLabel("IP:");
		lblNewLabel_1.setBounds(374, 40, 46, 14);
		getContentPane().add(lblNewLabel_1);

		ipField = new JtextFieldGenerico(".1234567890");
		ipField.setBounds(374, 65, 229, 29);
		getContentPane().add(ipField);
		ipField.setColumns(10);
		ipField.setMaximoCaracteres(15);

		numeroPortasField = new JtextFieldGenerico("1234567890");
		numeroPortasField.setBounds(470, 149, 133, 29);
		getContentPane().add(numeroPortasField);

		JLabel lblNewLabel_2 = new JLabel("Numero de Portas:");
		lblNewLabel_2.setBounds(470, 124, 105, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Concentrador:");
		lblNewLabel_3.setBounds(55, 212, 141, 14);
		getContentPane().add(lblNewLabel_3);
		
		carregarConcentrador();
		concentradorCombo.setBounds(55, 237, 248, 29);
		getContentPane().add(concentradorCombo);
		
		JLabel lblNewLabel_4 = new JLabel("Caixa:");
		lblNewLabel_4.setBounds(355, 212, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		carregarCaixas();
		caixaCombo.setBounds(355, 237, 248, 29);
		getContentPane().add(caixaCombo);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(514, 305, 89, 29);
		getContentPane().add(btnAdicionar);

	}
	
	private void carregarConcentrador() throws BusinessException {
		List<Concentrador> concentradoresList = new ArrayList<>();
		concentradorCombo = new JComboBox<>();
		fachada = new Fachada();
		concentradoresList = fachada.listarTodosConcentrador();
		for (Concentrador concentrador : concentradoresList) {	
			concentradorCombo.addItem(concentrador.getNome());
		}
	}

	private void carregarCaixas() throws BusinessException {
		List<Caixa> caixasList = new ArrayList<>();
		caixaCombo = new JComboBox<>();
		caixasList = fachada.listarTodosCaixa();
		for (Caixa caixa : caixasList) {
			caixaCombo.addItem(caixa.getNome());
		}
	}



	public JTextField getNomeFild() {
		return nomeField;
	}

	public JTextField getLoginFild() {
		return LoginField;
	}

	public JPasswordField getSenhaField() {
		return senhaField;
	}

	public JTextField getIpFild() {
		return ipField;
	}


	
	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}

	public JtextFieldGenerico getNumeroPortasField() {
		return numeroPortasField;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public JTextField getLoginField() {
		return LoginField;
	}

	public JtextFieldGenerico getIpField() {
		return ipField;
	}

	public JComboBox<String> getConcentradorCombo() {
		return concentradorCombo;
	}

	public JComboBox<String> getCaixaCombo() {
		return caixaCombo;
	}

	public Fachada getFachada() {
		return fachada;
	}
	


	
	
}

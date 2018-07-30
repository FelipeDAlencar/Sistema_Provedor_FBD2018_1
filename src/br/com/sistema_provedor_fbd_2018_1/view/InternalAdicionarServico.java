package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Porta;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

@SuppressWarnings("serial")
public class InternalAdicionarServico extends TelaInternal  {
	private Fachada fachada;
	private JLabel enderecoCheckLabel;
	private JCheckBox enderecoCheckBox;
	//Edereço
	private JLabel bairroLabel, complementoLabel, ruaLabel, numeroLabel;
	private JLabel cidadeLabel;
	private JTextField bairroField, complementoField, ruaField;
	private JtextFieldGenerico numeroField;
	private JComboBox<String> cidadesComboBox;
	
	//Servico
	private JComboBox<String> servicosComboBox;
	private JTextField LoginField;
	private JPasswordField senhaField;
	
	//switch
	private JComboBox<String> switchComboBox;
	private JComboBox<String> portaComboBox;
	
	private Botao btnSalvar;


	public InternalAdicionarServico(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super("Novo Serviço", telaPrincipal, actionListener);
		setBounds(400, 80, 630, 450);
		getContentPane().setLayout(null);
		fachada = new Fachada();
	}

	@Override
	public void inicializar() throws BusinessException {
		enderecoCheckBox = new JCheckBox("Usar Endereço do Cliente");
		enderecoCheckBox.setBounds(26,7,174,30);
		getContentPane().add(enderecoCheckBox);
		
		
		ruaLabel = new JLabel("Endereço:");
		ruaLabel.setBounds(26, 30, 100, 50);
		getContentPane().add(ruaLabel);

		ruaField = new JTextField();
		ruaField.setBounds(26, 73, 453, 30);
		getContentPane().add(ruaField);

		numeroLabel = new JLabel("Número:");
		numeroLabel.setBounds(510, 30, 88, 50);
		getContentPane().add(numeroLabel);

		numeroField = new JtextFieldGenerico("1234567890");
		numeroField.setBounds(510, 73, 88, 30);
		getContentPane().add(numeroField);

		complementoLabel = new JLabel("Complemento:");
		complementoLabel.setBounds(456, 102, 100, 50);
		getContentPane().add(complementoLabel);

		complementoField = new JTextField();
		complementoField.setBounds(456, 144, 142, 30);
		getContentPane().add(complementoField);

		bairroLabel = new JLabel("Bairro:");
		bairroLabel.setBounds(26, 102, 100, 50);
		getContentPane().add(bairroLabel);

		bairroField = new JTextField();
		bairroField.setBounds(26, 144, 180, 30);
		getContentPane().add(bairroField);

		// Informaçoes de Cidade
		cidadeLabel = new JLabel("Cidade:");
		cidadeLabel.setBounds(236, 102, 100, 50);
		getContentPane().add(cidadeLabel);

		carregarCidades();
		cidadesComboBox.setBounds(236, 144, 193, 30);
		getContentPane().add(cidadesComboBox);
		
		//informacoes switch
		JLabel lblSwitch = new JLabel("Switch:");
		lblSwitch.setBounds(26, 196, 46, 14);
		getContentPane().add(lblSwitch);
		
		carregarSwitchs();
		switchComboBox.setBounds(26, 221, 310, 30);
		getContentPane().add(switchComboBox);
		

		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setBounds(381, 196, 46, 14);
		getContentPane().add(lblPorta);
		
		carregarPortas();
		portaComboBox.setBounds(381, 221, 217, 30);
		getContentPane().add(portaComboBox);
		
		//infomacoes servico

		JLabel lblServico = new JLabel("Serviço:");
		lblServico.setBounds(26, 274, 46, 14);
		getContentPane().add(lblServico);
		
		carregarServicos();
		servicosComboBox.setBounds(26, 299, 200, 30);
		getContentPane().add(servicosComboBox);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(252, 274, 46, 14);
		getContentPane().add(lblLogin);

		LoginField = new JTextField();
		LoginField.setToolTipText("Login");
		LoginField.setBounds(252, 299, 141, 29);
		getContentPane().add(LoginField);
		LoginField.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(414, 274, 46, 14);
		getContentPane().add(lblSenha);

		senhaField = new JPasswordField();
		senhaField.setBounds(424, 300, 174, 29);
		getContentPane().add(senhaField);
		
		btnSalvar = new Botao("resource/imagens/botoes/bnt-salvar.png", "Salvar");
		btnSalvar.setBounds(498,356,100,40);
		getContentPane().add(btnSalvar);

		
	}
	
	private void carregarCidades() throws BusinessException {
		fachada=new Fachada();
		List<Cidade> cidadesList = new ArrayList<>();
		cidadesComboBox = new JComboBox<>();
		cidadesList = fachada.listarTodosCidades();
		for (Cidade cidade : cidadesList) {
			cidadesComboBox.addItem(cidade.getNome()+" - "+ cidade.getEstado());
		}
	}
	
	private void carregarServicos() throws BusinessException {
		List<Servico> servicosList = new ArrayList<>();
		servicosComboBox = new JComboBox<>();
		servicosList = fachada.listarTodosServico();
		for (Servico servico : servicosList) {
			servicosComboBox.addItem(servico.getNome());
		}
	}
	
	private void carregarSwitchs() throws BusinessException {
		List<Switch> switchsList = new ArrayList<>();
		switchComboBox = new JComboBox<>();
		switchsList = fachada.listarTodosSwitch();
		for (Switch sw : switchsList) {
			switchComboBox.addItem(sw.getNome());
		}
	}
	
	private void carregarPortas() throws BusinessException {
		List<Porta> portasList = new ArrayList<>();
		Switch sw = fachada.buscarSwitchPorNome(switchComboBox.getSelectedItem().toString());
		portaComboBox = new JComboBox<>();
		portasList = fachada.buscarPortaPorSwitch(sw.getId());
		for (Porta porta : portasList) {
			portaComboBox.addItem(String.valueOf(porta.getNumero()));
		}
	}

	public Fachada getFachada() {
		return fachada;
	}

	public JLabel getEnderecoCheckLabel() {
		return enderecoCheckLabel;
	}

	public JCheckBox getEnderecoCheckBox() {
		return enderecoCheckBox;
	}

	public JLabel getBairroLabel() {
		return bairroLabel;
	}

	public JLabel getComplementoLabel() {
		return complementoLabel;
	}

	public JLabel getRuaLabel() {
		return ruaLabel;
	}

	public JLabel getNumeroLabel() {
		return numeroLabel;
	}

	public JLabel getCidadeLabel() {
		return cidadeLabel;
	}

	public JTextField getBairroField() {
		return bairroField;
	}

	public JTextField getComplementoField() {
		return complementoField;
	}

	public JTextField getRuaField() {
		return ruaField;
	}

	public JtextFieldGenerico getNumeroField() {
		return numeroField;
	}

	public JComboBox<String> getCidadesComboBox() {
		return cidadesComboBox;
	}

	public JComboBox<String> getServicosComboBox() {
		return servicosComboBox;
	}

	public JTextField getLoginField() {
		return LoginField;
	}

	public JPasswordField getSenhaField() {
		return senhaField;
	}

	public JComboBox<String> getSwitchComboBox() {
		return switchComboBox;
	}

	public JComboBox<String> getPortaComboBox() {
		return portaComboBox;
	}

	public Botao getBtnSalvar() {
		return btnSalvar;
	}
	

}

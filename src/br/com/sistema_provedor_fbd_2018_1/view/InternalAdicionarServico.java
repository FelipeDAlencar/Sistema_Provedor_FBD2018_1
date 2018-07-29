package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Porta;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

public class InternalAdicionarServico extends TelaInternal  {
	Fachada fachada;
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


	public InternalAdicionarServico(TelaPrincipal telaPrincipal, ActionListener actionListener)
			throws BusinessException {
		super("Novo Serviço", telaPrincipal, actionListener);
		setBounds(400, 100, 630, 450);
		getContentPane().setLayout(null);
		fachada = new Fachada();
	}

	@Override
	public void inicializar() throws BusinessException {
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
		portasList = fachada.buscarPortaPorSwitch(1);
		for (Porta porta : portasList) {
			portaComboBox.addItem(String.valueOf(porta.getNumero()));
		}
	}
	

}

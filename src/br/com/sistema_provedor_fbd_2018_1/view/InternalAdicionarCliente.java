package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class InternalAdicionarCliente extends TelaInternal{
	private JTabbedPane tabbedPane;
	private JPanel panelCliente;
	private PanelContato panelContatos;
	private JLabel nomeLabel, cpfLabel, rgLabel, dataNascimentoLabel;	
	private JLabel bairroLabel, complementoLabel, ruaLabel,numeroLabel;
	private JLabel cidadeLabel,estadoLabel, cepLabel;
	private JTextField nomeField, cpfField, rgField, dataNascimentoField;
	private JTextField bairroField, complementoField, ruaField,numeroField;
	private JComboBox<String> cidadesComboBox;
	private JTextField estadoField, cepField;
	private Botao bntSalvar;

	public InternalAdicionarCliente(TelaPrincipal telaPrincipal) throws BusinessException {
		super("Adicionar Cliente", telaPrincipal);
		setLayout(null);
		setVisible(false);
	}

	
	@Override
	public void inicializar() throws BusinessException {
		tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, TelaInternal.LARGURA, TelaInternal.ALTURA-270);
		
		panelContatos = new PanelContato();
		
		panelCliente = new JPanel();;
		panelCliente.setLayout(null);
		
		bntSalvar = new Botao("resource/imagens/botoes/bnt-salvar.png","Salvar");
		bntSalvar.setBounds(TelaInternal.LARGURA-255, TelaInternal.ALTURA-270,100, 40);
		
		//Informacoes Cliente
		nomeLabel = new JLabel("Nome Completo:");
		nomeLabel.setBounds(176,68,100,50);
		panelCliente.add(nomeLabel);
		
		nomeField = new JTextField();
		nomeField.setBounds(176,118,450,30);
		panelCliente.add(nomeField);
		
		cpfLabel = new JLabel("CPF:");
		cpfLabel.setBounds(696, 68, 100, 50);
		panelCliente.add(cpfLabel);
		
		cpfField = new JTextField();
		cpfField.setBounds(696,118,230,30);
		panelCliente.add(cpfField);
		
		rgLabel = new JLabel("RG:");
		rgLabel.setBounds(1006,68,100,50);
		panelCliente.add(rgLabel);
		
		rgField = new JTextField();
		rgField.setBounds(1006,118,200,30);
		panelCliente.add(rgField);
		
		dataNascimentoLabel = new JLabel("Data de Nascimento:");
		dataNascimentoLabel.setBounds(176,168,200,50);
		panelCliente.add(dataNascimentoLabel);
		
		dataNascimentoField = new JTextField();
		dataNascimentoField.setBounds(176,218,150,30);
		panelCliente.add(dataNascimentoField);
		
		//Informacoes Endereco
		ruaLabel = new JLabel("Endereço:");
		ruaLabel.setBounds(406,168,100,50);
		panelCliente.add(ruaLabel);
		
		ruaField = new JTextField();
		ruaField.setBounds(406,218,420,30);
		panelCliente.add(ruaField);
		
		numeroLabel = new JLabel("Número:");
		numeroLabel.setBounds(896,168,100,50);
		panelCliente.add(numeroLabel);
		
		numeroField = new JTextField();
		numeroField.setBounds(896,218,60,30);
		panelCliente.add(numeroField);
		
		complementoLabel = new JLabel("Complemento:");
		complementoLabel.setBounds(1026,168,100,50);
		panelCliente.add(complementoLabel);
		
		complementoField = new JTextField();
		complementoField.setBounds(1026,218,180,30);
		panelCliente.add(complementoField);
		
		bairroLabel = new JLabel("Bairro:");
		bairroLabel.setBounds(176,268,100,50);
		panelCliente.add(bairroLabel);
		
		bairroField = new JTextField();
		bairroField.setBounds(176,318,180,30);
		panelCliente.add(bairroField);
		
		//Informaçoes de Cidade
		cidadeLabel = new JLabel("Cidade:");
		cidadeLabel.setBounds(456,268,100,50);
		panelCliente.add(cidadeLabel);
		
		carregarCidades();
		cidadesComboBox.setBounds(456,318,200,30);
		panelCliente.add(cidadesComboBox);
		
		estadoLabel = new JLabel("Estado:");
		estadoLabel.setBounds(726,268,100,50);
		panelCliente.add(estadoLabel);
		
		estadoField = new JTextField();
		estadoField.setBounds(726,318,250,30);
		panelCliente.add(estadoField);
		
		cepLabel = new JLabel("CEP:");
		cepLabel.setBounds(1056, 268, 100, 50);
		panelCliente.add(cepLabel);
		
		cepField = new JTextField();
		cepField.setBounds(1056, 318, 150, 30);
		panelCliente.add(cepField);
		
		tabbedPane.add("Novo Cliente", panelCliente);
		tabbedPane.add("Contatos", panelContatos);
		
	
		getContentPane().add(tabbedPane);
		getContentPane().add(bntSalvar);
		
	}
	
	@SuppressWarnings("unused")
	private void carregarCidades() throws BusinessException{
		List<Cidade> cidadesList = new ArrayList<>();
		cidadesComboBox = new JComboBox<>();
		Fachada fachada = new Fachada();
		cidadesList=fachada.listarTodosCidades();
		for (Cidade cidade : cidadesList) {
			cidadesComboBox.addItem(cidade.getNome());
		}
	}
}

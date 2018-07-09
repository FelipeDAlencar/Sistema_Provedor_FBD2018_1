package br.com.sistema_provedor_fbd_2018_1.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

@SuppressWarnings("serial")
public class InternalLocalizarCliente extends TelaInternal{
	private JLabel nomeLabel, cpfLabel, rgLabel;
	private JLabel bairroLabel, ruaLabel;
	private JLabel cidadeLabel;
	private JLabel loginLabel, macLabel, codigoLabel;
	private JTextField nomeField, cpfField, rgField;
	private JTextField bairroField, ruaField;
	private JTextField loginField, macField, codigoField;
	private JComboBox<String> cidadesComboBox;
	private Botao bntFiltrar;
	

	public InternalLocalizarCliente(TelaPrincipal telaPrincipal) throws BusinessException {
		super("LocalizarCliente", telaPrincipal);
		setBounds(150, 50, 1050, 500);
		getContentPane().setLayout(null);
		setVisible(false);	
	}

	@Override
	public void inicializar() throws BusinessException {
		
		//Informacoes Cliente
		codigoLabel = new JLabel("Código:");
		codigoLabel.setBounds(85,30,100,50);
		getContentPane().add(codigoLabel);
		
		codigoField = new JTextField();
		codigoField.setBounds(85,80,130,30);
		getContentPane().add(codigoField);
		
		nomeLabel = new JLabel("Nome Completo:");
		nomeLabel.setBounds(294,30,100,50);
		getContentPane().add(nomeLabel);
		
		nomeField = new JTextField();
		nomeField.setBounds(294,81,400,30);
		getContentPane().add(nomeField);
		
		cpfLabel = new JLabel("CPF:");
		cpfLabel.setBounds(764, 31, 100, 50);
		getContentPane().add(cpfLabel);
		
		cpfField = new JTextField();
		cpfField.setBounds(764,81,200,30);
		getContentPane().add(cpfField);
		
		rgLabel = new JLabel("RG:");
		rgLabel.setBounds(85,144,100,50);
		getContentPane().add(rgLabel);
		
		rgField = new JTextField();
		rgField.setBounds(85,194,200,30);
		getContentPane().add(rgField);
		
		//Informacoes Usuario
		loginLabel = new JLabel("Login:");
		loginLabel.setBounds(360,144,100,50);
		getContentPane().add(loginLabel);
		
		loginField = new JTextField();
		loginField.setBounds(360,194,300,30);
		getContentPane().add(loginField);
		
		macLabel = new JLabel("MAC:");
		macLabel.setBounds(734, 144, 100, 50);
		getContentPane().add(macLabel);
		
		macField = new JTextField();
		macField.setBounds(734,194,230,30);
		getContentPane().add(macField);
		
		//informacoes Cidade
		
		ruaLabel = new JLabel("Endere\u00E7o:");
		ruaLabel.setBounds(85, 260, 100, 50);
		getContentPane().add(ruaLabel);
		
		ruaField = new JTextField();
		ruaField.setBounds(85,310,320,30);
		getContentPane().add(ruaField);
		
		bairroLabel = new JLabel("Bairro:");
		bairroLabel.setBounds(490, 260, 100, 50);
		getContentPane().add(bairroLabel);
		
		bairroField = new JTextField();
		bairroField.setBounds(490, 310, 230, 30);
		getContentPane().add(bairroField);
		
		cidadeLabel = new JLabel("Cidade:");
		cidadeLabel.setBounds(783, 260, 100, 50);
		getContentPane().add(cidadeLabel);
		
		carregarCidades();
		cidadesComboBox.setBounds(783, 310, 181, 30);
		getContentPane().add(cidadesComboBox);
		
		bntFiltrar = new Botao("resource/imagens/botoes/filtro.png", "Filtrar");
		bntFiltrar.setBounds(864, 384, 100, 40);
		getContentPane().add(bntFiltrar);
		
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

package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Endereco;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

@SuppressWarnings("serial")
public class InternalLocalizarCliente  extends TelaInternal{
	private Botao btnEditar;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;
	private JTextField buscarField;
	private Botao btnBuscar;
	private JLabel notf;
	private Fachada fachada;
	public InternalLocalizarCliente(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Clientes", telaPrincipal, actionListener);
		setBounds(150, 50, 1050, 510);
		getContentPane().setLayout(null);
		fachada = new  Fachada();
	}

	@Override
	public void inicializar(){	
		
		notf = new JLabel("Realize uma busca para filtrar os clientes");
		notf.setBounds(435, 247, 400, 54);
		getContentPane().add(notf);
		
		btnEditar = new Botao("resource/imagens/botoes/btn-selecionar.png","Selecionar");
		btnEditar.setBounds(50, 20, 146, 40);
		getContentPane().add(btnEditar);

		modelTable = new DefaultTableModel();
		modelTable.addColumn("Código");
		modelTable.addColumn("Nome");
		modelTable.addColumn("Cidade");


		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
		tabela.setBounds(0,0,600,400);

		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,126,928,300);
		
		

		getContentPane().add(barraRolagem);

		buscarField = new JTextField();
		buscarField.setBounds(50, 75, 808, 40);
		getContentPane().add(buscarField);
		buscarField.setColumns(10);

		btnBuscar = new Botao("resource/imagens/botoes/btn-buscar.png", "Buscar");
		btnBuscar.setBounds(871, 75, 107, 40);
		getContentPane().add(btnBuscar);
	}

	public void carregarClientes(List<Cliente> clientes) {
		notf.setText("Nunhum cliente encontrado");
		notf.setVisible(true);
		if (clientes.size()!=0)
			notf.setVisible(false);
		try {
			modelTable.setNumRows(0);
			for (Cliente cliente : clientes) {
				Endereco endereco = fachada.buscarEnderecoPorId(cliente.getEndereco_id());
				Cidade cidade = fachada.buscarCidadePorId(endereco.getCidade_id());
				String[] linha = {cliente.getId().toString(), cliente.getNome(),cidade.getNome()};
				modelTable.addRow(linha);
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}


	public Botao getBtnEditar() {
		return btnEditar;
	}


	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public JScrollPane getBarraRolagem() {
		return barraRolagem;
	}

	public JTable getTabela() {
		return tabela;
	}

	public JTextField getBuscarField() {
		return buscarField;
	}

	public Botao getBtnBuscar() {
		return btnBuscar;
	}







}

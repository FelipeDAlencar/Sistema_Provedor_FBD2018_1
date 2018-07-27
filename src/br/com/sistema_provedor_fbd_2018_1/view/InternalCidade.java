package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class InternalCidade extends TelaInternal{
	private Botao bntNovo, bntEditar, bntRemover, btnBuscar ;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;
	private JTextField buscaField;
	public InternalCidade(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Cidades", telaPrincipal, actionListener);
		setBounds(150, 20, 1050, 610);
		getContentPane().setLayout(null);
		setVisible(false);
	}

	@Override
	public void inicializar(){	
		bntEditar = new Botao("resource/imagens/botoes/editar-cidade.png","Editar Cidade");
		bntEditar.setBounds(50, 20, 159, 40);
		getContentPane().add(bntEditar);
		
		bntNovo = new Botao("resource/imagens/botoes/nova-cidade.png","Nova Cidade");
		bntNovo.setBounds(240, 20, 159, 40);
		getContentPane().add(bntNovo);
		
		bntRemover = new Botao("resource/imagens/botoes/remover-servico.png","Remover Cidade");
		bntRemover.setBounds(430, 20, 179, 40);
		getContentPane().add(bntRemover);
		
		modelTable = new DefaultTableModel();
		modelTable.addColumn("Id");
		modelTable.addColumn("Nome");
		modelTable.addColumn("Estado");
		modelTable.addColumn("Cep");
		
		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
		tabela.setBounds(0,0,600,400);
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,191,907,289);
		
		getContentPane().add(barraRolagem);
		
		JLabel lblBusca = new JLabel("Busca:");
		lblBusca.setBounds(50, 71, 46, 14);
		getContentPane().add(lblBusca);
		
		buscaField = new JTextField();
		buscaField.setBounds(50, 102, 200, 28);
		getContentPane().add(buscaField);
		buscaField.setColumns(10);
		
		btnBuscar = new Botao("", "Buscar");
		btnBuscar.setBounds(49, 140, 107, 40);
		getContentPane().add(btnBuscar);
	}
	
	public void carregarCidades(List<Cidade> cidades) {
		modelTable.setNumRows(0);
		for (Cidade cidade : cidades) {
			String[] linha = {cidade.getId().toString(), cidade.getNome(), cidade.getEstado(), cidade.getCep()};
			modelTable.addRow(linha);
		}
		
	}

	public Botao getBntNovo() {
		return bntNovo;
	}

	public Botao getBntEditar() {
		return bntEditar;
	}

	public Botao getBntRemover() {
		return bntRemover;
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

	public Botao getBtnBuscar() {
		return btnBuscar;
	}

	public JTextField getBuscaField() {
		return buscaField;
	}
	
	
}

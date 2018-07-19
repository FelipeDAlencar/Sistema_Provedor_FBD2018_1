package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

public class InternalFuncionario extends TelaInternal{
	private Botao bntNovo, bntEditar;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;
	
	public InternalFuncionario(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Funcionarios", telaPrincipal, actionListener);
		setBounds(150, 50, 1050, 500);
		getContentPane().setLayout(null);
		setVisible(false);	
	}

	@Override
	public void inicializar() throws BusinessException {
		bntEditar = new Botao("resource/imagens/botoes/editar-funcionario.png","Editar Funcionario");
		bntEditar.setBounds(50, 20, 200, 40);
		getContentPane().add(bntEditar);
		
		bntNovo = new Botao("resource/imagens/botoes/novo-funcionario.png","Novo Funcionario");
		bntNovo.setBounds(270, 20, 200, 40);
		getContentPane().add(bntNovo);
		
		modelTable = new DefaultTableModel();
		modelTable.addColumn("Id");
		modelTable.addColumn("Nome");
		modelTable.addColumn("Cargo");
		modelTable.addColumn("Data De Contrato");
		
		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
		tabela.setBounds(0,0,600,400);
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,60,930,400);
		
		getContentPane().add(barraRolagem);
	}
	
	public void carregarAtendimentos(List<Funcionario> funcionarios) {
		for (Funcionario funcionario : funcionarios) {
			
			String[] linha = {funcionario.getId().toString(), funcionario.getNome(), funcionario.getCargo(), funcionario.getData_contrato()};
			modelTable.addRow(linha);
		}
		
	}

	public Botao getBntNovo() {
		return bntNovo;
	}

	public Botao getBntEditar() {
		return bntEditar;
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
	
	

}

package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

@SuppressWarnings("serial")
public class InternalCidade extends TelaInternal{
	private Botao bntNovo, bntEditar, bntRemover;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;
	public InternalCidade(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Cidades", telaPrincipal, actionListener);
		setBounds(150, 50, 1050, 500);
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
		barraRolagem.setBounds(50,60,930,400);
		
		getContentPane().add(barraRolagem);
	}
	
	public void carregarCidades(List<Cidade> cidades) {
		for (Cidade cidade : cidades) {
			
			String[] linha = {cidade.getId().toString(), cidade.getNome(), cidade.getEstado(), cidade.getCep()};
			modelTable.addRow(linha);
		}
		
	}

}

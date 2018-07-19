package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

@SuppressWarnings("serial")
public class InternalServicos extends TelaInternal{
	private Botao bntNovo, bntEditar, bntRemover;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;
	public InternalServicos(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Serviços", telaPrincipal, actionListener);
		setBounds(150, 50, 1050, 500);
		getContentPane().setLayout(null);
		setVisible(false);
	}

	@Override
	public void inicializar(){	
		bntEditar = new Botao("resource/imagens/botoes/editar-servico.png","Editar Serviço");
		bntEditar.setBounds(50, 20, 200, 40);
		getContentPane().add(bntEditar);
		
		bntNovo = new Botao("resource/imagens/botoes/adicionar-servico.png","Novo Serviço");
		bntNovo.setBounds(270, 20, 200, 40);
		getContentPane().add(bntNovo);
		
		bntRemover = new Botao("resource/imagens/botoes/remover-servico.png","Remover Serviço");
		bntRemover.setBounds(490, 20, 200, 40);
		getContentPane().add(bntRemover);
		
		modelTable = new DefaultTableModel();
		modelTable.addColumn("Id");
		modelTable.addColumn("Nome");
		modelTable.addColumn("Upload");
		modelTable.addColumn("Download");
		modelTable.addColumn("Valor");
		
		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
		tabela.setBounds(0,0,600,400);
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,60,930,400);
		
		getContentPane().add(barraRolagem);
	}
	
	public void carregarAtendimentos(List<Servico> servicos) {
		for (Servico servico : servicos) {
			
			String[] linha = {servico.getId().toString(), servico.getNome(), Integer.toString(servico.getUpload()), 
					Integer.toString(servico.getDownload())};
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
	
	

}

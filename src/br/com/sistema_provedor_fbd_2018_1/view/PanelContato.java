package br.com.sistema_provedor_fbd_2018_1.view;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;

@SuppressWarnings("serial")
public class PanelContato extends JPanel{
	private Botao bntAdicionar, bntEditar, bntExcluir;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;
	
	public PanelContato() {
		setLayout(null);
		bntAdicionar = new Botao("resource/imagens/botoes/adicionar-contato.png","Adicionar");
		bntAdicionar.setLocation(50, 10);
		bntAdicionar.setSize(135, 40);
		add(bntAdicionar);
		
		bntEditar = new Botao("resource/imagens/botoes/editar-contato.png", "Editar");
		bntEditar.setLocation(195, 10);
		bntEditar.setSize(110, 40);
		add(bntEditar);
		
		bntExcluir = new Botao("resource/imagens/botoes/excluir-contato.png", "Excluir");
		bntExcluir.setLocation(315, 10);
		bntExcluir.setSize(115, 40);
		add(bntExcluir);
		
		modelTable = new DefaultTableModel();
		modelTable.addColumn("Responsável");
		modelTable.addColumn("Contato");
		
		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(250);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(250);
		tabela.setBounds(0,0,1200,400);
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,60,1200,400);
		
		add(barraRolagem);
		
	}
	public void carregarContatos(List<Contato> contatos) {
		for (Contato contato : contatos) {
			String[] linha = {contato.getResponsavel(),contato.getContato()};
			modelTable.addRow(linha);
		}
	}
	

}

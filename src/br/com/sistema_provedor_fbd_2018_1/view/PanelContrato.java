package br.com.sistema_provedor_fbd_2018_1.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class PanelContrato extends JPanel {
	private Botao bntAdicionar, bntEditar, bntExcluir;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;
	
	public PanelContrato() {
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
		modelTable.addColumn("ID");
		modelTable.addColumn("Valor Mensal");
		modelTable.addColumn("Numero de Parcelas");
		
		
		
		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(250);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(250);
		tabela.setBounds(0,0,1200,400);
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,60,1200,142);
		
		add(barraRolagem);
		
	}
//	public void carregarContatos(List<Contato> contatos) {
//		modelTable.setNumRows(0);
//		for (Contato contato : contatos) {
//			String[] linha = {contato.getResponsavel(),contato.getContato()};
//			modelTable.addRow(linha);
//		}
//	}
	public Botao getBntAdicionar() {
		return bntAdicionar;
	}
	public void setBntAdicionar(Botao bntAdicionar) {
		this.bntAdicionar = bntAdicionar;
	}
	public Botao getBntEditar() {
		return bntEditar;
	}
	public void setBntEditar(Botao bntEditar) {
		this.bntEditar = bntEditar;
	}
	public Botao getBntExcluir() {
		return bntExcluir;
	}
	public void setBntExcluir(Botao bntExcluir) {
		this.bntExcluir = bntExcluir;
	}
	public DefaultTableModel getModelTable() {
		return modelTable;
	}
	public void setModelTable(DefaultTableModel modelTable) {
		this.modelTable = modelTable;
	}
	public JScrollPane getBarraRolagem() {
		return barraRolagem;
	}
	public void setBarraRolagem(JScrollPane barraRolagem) {
		this.barraRolagem = barraRolagem;
	}
	public JTable getTabela() {
		return tabela;
	}
	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}
	


}

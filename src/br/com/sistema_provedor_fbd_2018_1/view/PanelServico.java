package br.com.sistema_provedor_fbd_2018_1.view;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.entidade.ServicoCliente;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

@SuppressWarnings("serial")
public class PanelServico extends JPanel {
	private Botao bntAdicionar, bntEditar, bntExcluir;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;

	public PanelServico() {
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
		modelTable.addColumn("Código");
		modelTable.addColumn("Descricão");



		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(250);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(250);
		tabela.setBounds(0,0,1200,400);

		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,60,1200,400);

		add(barraRolagem);

	}
	public void carregarServicos(List<ServicoCliente> servicos) {
		modelTable.setNumRows(0);
		try {
			for (ServicoCliente servico : servicos) {
				Fachada fachada = new Fachada();
				Servico ser;
				ser = fachada.buscarServicoPorId(servico.getServico_id());
				String[] linha = {String.valueOf(servico.getId()),ser.getNome()};
				modelTable.addRow(linha);
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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

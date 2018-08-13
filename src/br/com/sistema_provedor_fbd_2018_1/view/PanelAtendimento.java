package br.com.sistema_provedor_fbd_2018_1.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.enuns.enumAtendimento;

@SuppressWarnings("serial")
public class PanelAtendimento extends JPanel{
	private Botao bntAdicionar, bntConcluir, bntCancelar;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;
	private ArrayList<Contato> contatos;
	public PanelAtendimento() {
		setLayout(null);

		contatos= new ArrayList<>();

		bntAdicionar = new Botao("resource/imagens/botoes/adicionar-contato.png","Adicionar");
		bntAdicionar.setLocation(50, 10);
		bntAdicionar.setSize(135, 40);
		add(bntAdicionar);

		bntConcluir = new Botao("resource/imagens/botoes/editar-contato.png", "Concluir");
		bntConcluir.setLocation(195, 10);
		bntConcluir.setSize(110, 40);
		add(bntConcluir);

		bntCancelar = new Botao("resource/imagens/botoes/excluir-contato.png", "Cancelar");
		bntCancelar.setLocation(315, 10);
		bntCancelar.setSize(115, 40);
		add(bntCancelar);

		modelTable = new DefaultTableModel();
		modelTable.addColumn("Protocolo");
		modelTable.addColumn("Data");
		modelTable.addColumn("Motivo");
		modelTable.addColumn("status");

		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(250);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(250);
		tabela.setBounds(0,0,1200,400);

		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,61,930,250);

		add(barraRolagem);

	}
	
	public void carregarAtendimento(List<Atendimento> atendimentos) {
		modelTable.setNumRows(0);
		for (Atendimento atendimento : atendimentos) {
			if (atendimento.getStatus()!=enumAtendimento.CANCELADO) {
				String[] linha = {atendimento.getId().toString(),
						atendimento.getData_atendimento(),
						atendimento.getMotivo(),
						atendimento.getStatus().getStatus()};
				modelTable.addRow(linha);
			}
		}
	}
	
	public Botao getBntAdicionar() {
		return bntAdicionar;
	}
	public Botao getBntConcluir() {
		return bntConcluir;
	}
	public Botao getBntCancelar() {
		return bntCancelar;
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
	public ArrayList<Contato> getContatos() {
		return contatos;
	}


}

package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

@SuppressWarnings("serial")
public class InternalAtendimentos extends TelaInternal {
	private Botao btnAbrir,btnReagendarAtrasados;
	private DefaultTableModel modelTable, modelTableAtrasados;
	private JScrollPane barraRolagem, scrollTabelaAtrasados;
	private JTable tabela, tabelaAtrasados;

	public InternalAtendimentos(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Meus Atendimentos", telaPrincipal, actionListener);
		setBounds(150, 50, 1066, 596);
		getContentPane().setLayout(null);
		setVisible(false);
	}

	@Override
	public void inicializar() throws BusinessException {
		btnAbrir = new Botao("resource/imagens/botoes/abrir-atendimento.png", "Novo Atendimento");
		btnAbrir.setBounds(50, 20, 200, 40);
		getContentPane().add(btnAbrir);

		modelTable = new DefaultTableModel();
		modelTable.addColumn("Protocolo");
		modelTable.addColumn("Cliente");
		modelTable.addColumn("Motivo");
		modelTable.addColumn("Data de atendimento");
		modelTable.addColumn("Status");

		modelTableAtrasados = new DefaultTableModel();
		modelTableAtrasados.addColumn("Protocolo");
		modelTableAtrasados.addColumn("Cliente");
		modelTableAtrasados.addColumn("Motivo");
		modelTableAtrasados.addColumn("Data de atendimento");
		modelTableAtrasados.addColumn("Status");

		tabelaAtrasados = new JTable(modelTableAtrasados);
		tabelaAtrasados.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
		tabelaAtrasados.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
		tabelaAtrasados.setBounds(0, 0, 600, 400);

		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
		tabela.setBounds(0, 0, 600, 400);

		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50, 80, 920, 171);
		getContentPane().add(barraRolagem);

		scrollTabelaAtrasados = new JScrollPane(tabelaAtrasados);
		scrollTabelaAtrasados.setBounds(50, 362, 920, 171);
		getContentPane().add(scrollTabelaAtrasados);
		
		btnReagendarAtrasados = new Botao("","Reagendar Atrasados");
		btnReagendarAtrasados.setBounds(50, 316, 200, 40);
		getContentPane().add(btnReagendarAtrasados);
	}

	public void carregarAtendimentos(List<Atendimento> atendimentos) {
		modelTable.setNumRows(0);
		for (Atendimento atendimento : atendimentos) {

			String[] linha = {
					atendimento.getId().toString(),
					"cliente", 
					atendimento.getMotivo(),
					atendimento.getData_atendimento(), 
					atendimento.getStatus().getStatus() };
			modelTable.addRow(linha);
		}
	}

	public void carregarAtendimentosAtrasados(List<Atendimento> atendimentos) {
		modelTableAtrasados.setNumRows(0);
		for (Atendimento atendimento : atendimentos) {
			String[] linha = {
					atendimento.getId().toString(),
					"cliente",
					atendimento.getMotivo(),
					atendimento.getData_atendimento(),
					atendimento.getStatus().getStatus() };
			modelTableAtrasados.addRow(linha);
		}
	}

	public Botao getBtnAbrir() {
		return btnAbrir;
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

	public Botao getBtnReagendarAtrasados() {
		return btnReagendarAtrasados;
	}

	public DefaultTableModel getModelTableAtrasados() {
		return modelTableAtrasados;
	}

	public JScrollPane getScrollTabelaAtrasados() {
		return scrollTabelaAtrasados;
	}

	public JTable getTabelaAtrasados() {
		return tabelaAtrasados;
	}
	
}

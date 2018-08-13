package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.fachada.IFachada;

@SuppressWarnings("serial")
public class InternalAtendimentos extends TelaInternal {
	private Botao btnReagendarAtrasados;
	private DefaultTableModel modelTable, modelTableAtrasados;
	private JScrollPane barraRolagem, scrollTabelaAtrasados;
	private JTable tabela, tabelaAtrasados;
	private IFachada fachada = new Fachada();

	public InternalAtendimentos(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Meus Atendimentos", telaPrincipal, actionListener);
		setBounds(150, 50, 1066, 596);
		getContentPane().setLayout(null);
		setVisible(false);
	}

	@Override
	public void inicializar() throws BusinessException {

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
		try {
			for (Atendimento atendimento : atendimentos) {
				Cliente cliente  = fachada.buscarClientePorId(atendimento.getCliente_id());
				String[] linha = {
						atendimento.getId().toString(),
						cliente.getNome(), 
						atendimento.getMotivo(),
						atendimento.getData_atendimento(), 
						atendimento.getStatus().getStatus() };
				modelTable.addRow(linha);
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void carregarAtendimentosAtrasados(List<Atendimento> atendimentos) {
		modelTableAtrasados.setNumRows(0);
		try {
			for (Atendimento atendimento : atendimentos) {
				Cliente cliente  = fachada.buscarClientePorId(atendimento.getCliente_id());
				String[] linha = {
						atendimento.getId().toString(),
						cliente.getNome(),
						atendimento.getMotivo(),
						atendimento.getData_atendimento(),
						atendimento.getStatus().getStatus() };
				modelTableAtrasados.addRow(linha);
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

@SuppressWarnings("serial")
public class InternalAtendimentos extends TelaInternal{
	private Botao btnNovo, btnAbrir;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;

	public InternalAtendimentos(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Meus Atendimentos", telaPrincipal, actionListener);
		setBounds(150, 50, 1050, 500);
		getContentPane().setLayout(null);
		setVisible(false);	
	}

	@Override
	public void inicializar() throws BusinessException {
		btnAbrir = new Botao("resource/imagens/botoes/abrir-atendimento.png","Abrir Atendimento");
		btnAbrir.setBounds(50, 20, 200, 40);
		getContentPane().add(btnAbrir);
		
		btnNovo = new Botao("resource/imagens/botoes/novo-atendimento.png","Novo Atendimento");
		btnNovo.setBounds(270, 20, 200, 40);
		getContentPane().add(btnNovo);
		
		modelTable = new DefaultTableModel();
		modelTable.addColumn("Protocolo");
		modelTable.addColumn("Cliente");
		modelTable.addColumn("Motivo");
		modelTable.addColumn("Status");
		
		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
		tabela.setBounds(0,0,600,400);
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,60,930,400);
		
		getContentPane().add(barraRolagem);
	}
	
	public void carregarAtendimentos(List<Atendimento> atendimentos) {
		for (Atendimento atendimento : atendimentos) {
			
			String[] linha = {atendimento.getProtocolo(),"cliente", atendimento.getMotivo(), atendimento.getStatus()};
			modelTable.addRow(linha);
		}
	}

	public Botao getBtnNovo() {
		return btnNovo;
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
	
	
}

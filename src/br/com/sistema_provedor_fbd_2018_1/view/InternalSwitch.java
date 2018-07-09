package br.com.sistema_provedor_fbd_2018_1.view;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;

@SuppressWarnings("serial")
public class InternalSwitch extends TelaInternal{
	private Botao bntNovo, bntEditar, bntRemover;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;

	public InternalSwitch(TelaPrincipal telaPrincipal) throws BusinessException {
		super("Meus Atendimentos", telaPrincipal);
		setBounds(150, 50, 1050, 500);
		getContentPane().setLayout(null);
		setVisible(false);	
	}

	@Override
	public void inicializar() throws BusinessException {
		bntEditar = new Botao("resource/imagens/botoes/abrir-switch.png","Editar Switch");
		bntEditar.setBounds(50, 20, 160, 40);
		getContentPane().add(bntEditar);
		
		bntNovo = new Botao("resource/imagens/botoes/novo-switch.png","Novo Switch");
		bntNovo.setBounds(230, 20, 160, 40);
		getContentPane().add(bntNovo);
		
		bntRemover = new Botao("resource/imagens/botoes/novo-switch.png","Remover Switch");
		bntRemover.setBounds(410, 20, 180, 40);
		getContentPane().add(bntRemover);
		
		modelTable = new DefaultTableModel();
		modelTable.addColumn("ID");
		modelTable.addColumn("Nome");
		modelTable.addColumn("IP");
		
		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
		tabela.setBounds(0,0,600,400);
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,60,930,400);
		
		getContentPane().add(barraRolagem);
	}
	
	public void carregarAtendimentos(List<Switch> sws) {
		for (Switch sw : sws) {
			
			String[] linha = {Integer.toString(sw.getId()), sw.getIp(), sw.getNome(), sw.getIp()};
			modelTable.addRow(linha);
		}
	}

}

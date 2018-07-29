package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.sistema_provedor_fbd_2018_1.entidade.Switch;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InternalSwitch extends TelaInternal{
	private Botao btnNovo, btnEditar, btnRemover;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;
	private JButton btnBuscar;
	private JTextField buscaField;
	

	public InternalSwitch(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Meus Atendimentos", telaPrincipal, actionListener);
		setBounds(150, 20, 1050, 610);
		getContentPane().setLayout(null);
		setVisible(false);	
	}

	@Override
	public void inicializar() throws BusinessException {
		btnEditar = new Botao("resource/imagens/botoes/abrir-switch.png","Editar Switch");
		btnEditar.setBounds(50, 20, 160, 40);
		getContentPane().add(btnEditar);
		
		btnNovo = new Botao("resource/imagens/botoes/novo-switch.png","Novo Switch");
		btnNovo.setBounds(230, 20, 160, 40);
		getContentPane().add(btnNovo);
		
		btnRemover = new Botao("resource/imagens/botoes/novo-switch.png","Remover Switch");
		btnRemover.setBounds(410, 20, 180, 40);
		getContentPane().add(btnRemover);
		
		modelTable = new DefaultTableModel();
		modelTable.addColumn("ID");
		modelTable.addColumn("Nome");
		modelTable.addColumn("IP");
		modelTable.addColumn("Nº de portas");
		
		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
		tabela.setBounds(0,0,600,400);
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,191,930,379);
		
		getContentPane().add(barraRolagem);
		
		JLabel lblBusca = new JLabel("Busca:");
		lblBusca.setBounds(50, 71, 46, 14);
		getContentPane().add(lblBusca);
		
		buscaField = new JTextField();
		buscaField.setBounds(50, 102, 200, 28);
		getContentPane().add(buscaField);
		buscaField.setColumns(10);
		
		btnBuscar = new Botao("", "Buscar");
		btnBuscar.setBounds(49, 140, 107, 40);
		getContentPane().add(btnBuscar);
	}
	
	public void carregarSwitchs(List<Switch> sws) {
		modelTable.setNumRows(0);
		for (Switch sw : sws) {			
			String[] linha = {Integer.toString(sw.getId()), sw.getNome(), sw.getIp(), String.valueOf(sw.getNumero_de_portas())};
			modelTable.addRow(linha);
		}
	}

	public Botao getBtnNovo() {
		return btnNovo;
	}

	public void setBtnNovo(Botao btnNovo) {
		this.btnNovo = btnNovo;
	}

	public Botao getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(Botao btnEditar) {
		this.btnEditar = btnEditar;
	}

	public Botao getBtnRemover() {
		return btnRemover;
	}

	public void setBtnRemover(Botao btnRemover) {
		this.btnRemover = btnRemover;
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

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JTextField getBuscaField() {
		return buscaField;
	}
	
	
	

}

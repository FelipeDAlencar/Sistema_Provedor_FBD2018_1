package br.com.sistema_provedor_fbd_2018_1.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PanelFinanceiro extends JPanel {
	private Botao btnNovoContrato;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem, barra2, barraGeral;
	private JTable tabela, tabela2;
	
	public PanelFinanceiro() {
		setLayout(null);
		btnNovoContrato = new Botao("","Novo Contrato");
		btnNovoContrato.setBounds(50, 10, 159, 40);
		add(btnNovoContrato);
		
		
		modelTable = new DefaultTableModel();
		modelTable.addColumn("ID contrato");
		modelTable.addColumn("Valor Mensal");
		modelTable.addColumn("Data de Vencimento");
		
		
		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(250);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(250);
		tabela.setBounds(0,0,1200,400);
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50, 257, 773, 180);
		
		
		tabela2 = new JTable(modelTable);
		tabela2.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(250);
		tabela2.getTableHeader().getColumnModel().getColumn(0).setMinWidth(250);
		tabela2.setBounds(0,0,1200,400);
		

		barra2 = new JScrollPane(tabela);
		barra2.setSize(773, 132);
		barra2.setLocation(50, 93);
		add(barra2);
		add(barraRolagem);
	
	}
	public Botao getBtnNovoContrato() {
		return btnNovoContrato;
	}
	public JScrollPane getBarraRolagem() {
		return barraRolagem;
	}
	public void setBarraRolagem(JScrollPane barraRolagem) {
		this.barraRolagem = barraRolagem;
	}
	public JScrollPane getBarra2() {
		return barra2;
	}
	public void setBarra2(JScrollPane barra2) {
		this.barra2 = barra2;
	}
	
	
	
}

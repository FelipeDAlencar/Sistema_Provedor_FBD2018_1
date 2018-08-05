package br.com.sistema_provedor_fbd_2018_1.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.sistema_provedor_fbd_2018_1.controller.ControllerAtendimentos;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contrato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Parcela;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class PanelFinanceiro extends JPanel {
	private DefaultTableModel modelTable;
	private Botao btnNovoContrato;
	private JPanel panelTabelas;
	private JScrollPane scrollFinanceiro;

	public PanelFinanceiro() {
		setLayout(null);
		btnNovoContrato = new Botao("","Novo Contrato");
		btnNovoContrato.setBounds(50,20,176,40);
		add(btnNovoContrato);
		
		panelTabelas = new JPanel();
		panelTabelas.setLayout(null);
		

	}
	
	public void carregarTabelas(ArrayList<Contrato> contratos) {
		
		try {
			int largura = 975;
			int altura = 230;
			int x = 10, y = 10;

			JTable tabela = new JTable(modelTable);
			ArrayList<JScrollPane> scrollPanes = new ArrayList<>();
			JScrollPane scrollPane = null;
			Fachada fachada = new Fachada();
			ArrayList<Parcela> parcelas;
			DefaultTableModel modelTable;
			for (int i = 0; i < contratos.size(); i++) {
				
				modelTable = new DefaultTableModel();
				modelTable.addColumn("ID contrato");
				modelTable.addColumn("Valor Mensal");
				modelTable.addColumn("Data de Vencimento");

				tabela = new JTable(modelTable);
				tabela.setSize(1200,300);

				parcelas = fachada.buscarParcelaPorContratoID(contratos.get(i).getId());
				modelTable.setNumRows(0);
				for (Parcela parcela : parcelas) {
					String[] linha = { String.valueOf(contratos.get(i).getId()), String.valueOf(parcela.getValor()),
							parcela.getData_vencimento() };
					modelTable.addRow(linha);
				}
				
				scrollPane = new JScrollPane(tabela);
				scrollPanes.add(scrollPane);
			}

			for (JScrollPane jScrollPaneAtual : scrollPanes) {
				jScrollPaneAtual.setBounds(x, y, largura, altura);
				panelTabelas.add(jScrollPaneAtual);
				y += altura;
			}
			panelTabelas.setPreferredSize(new Dimension(935, y+10 ));
			scrollFinanceiro = new JScrollPane(panelTabelas);
			scrollFinanceiro.setBounds(50,65,950,300);
			add(scrollFinanceiro);
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}

	public Botao getBtnNovoContrato() {
		return btnNovoContrato;
	}

	public void setBtnNovoContrato(Botao btnNovoContrato) {
		this.btnNovoContrato = btnNovoContrato;
	}

	
	// public JScrollPane getBarraRolagem() {
	// return barraRolagem;
	// }
	// public void setBarraRolagem(JScrollPane barraRolagem) {
	// this.barraRolagem = barraRolagem;
	// }
	// public JScrollPane getBarra2() {
	// return barra2;
	// }
	// public void setBarra2(JScrollPane barra2) {
	// this.barra2 = barra2;
	// }

}

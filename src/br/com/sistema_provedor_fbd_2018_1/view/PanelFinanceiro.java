package br.com.sistema_provedor_fbd_2018_1.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contrato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Parcela;
import br.com.sistema_provedor_fbd_2018_1.enuns.enumParcela;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import java.awt.Dimension;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class PanelFinanceiro extends JPanel {
	private DefaultTableModel modelTable;
	private Botao btnNovoContrato;
	private JPanel panelTabelas;
	private JScrollPane scrollFinanceiro;
	private JTable tabela;
	private ArrayList<JScrollPane> scrollPanes = new ArrayList<>();
	private JScrollPane scrollPane = null;
	private Fachada fachada = new Fachada();
	private ArrayList<Parcela> parcelas;
	private ArrayList<JTable> tabelas= new ArrayList<>();

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
			int largura = 925;
			int altura = 230;
			int x = 10, y = 10;

			
			for (int i = 0; i < contratos.size(); i++) {
				
				modelTable = new DefaultTableModel();
				modelTable.addColumn("Código");
				modelTable.addColumn("Valor Mensal");
				modelTable.addColumn("Data de Vencimento");

				tabela = new JTable(modelTable);
				tabela.setSize(1200,300);
				
				parcelas = fachada.buscarParcelaPorContratoID(contratos.get(i).getId());
				modelTable.setNumRows(0);
				for (Parcela parcela : parcelas) {
					if (parcela.getStatus()==enumParcela.ABERTO) {
						String[] linha = { String.valueOf(parcela.getId()), String.valueOf(parcela.getValor()),
								parcela.getData_vencimento() };
						modelTable.addRow(linha);
					}
				}
				
				scrollPane = new JScrollPane(tabela);
				tabelas.add(tabela);
				scrollPanes.add(scrollPane);
			}

			for (JScrollPane jScrollPaneAtual : scrollPanes) {
				jScrollPaneAtual.setBounds(x, y, largura, altura);
				panelTabelas.add(jScrollPaneAtual);
				y += altura;
			}
			panelTabelas.setPreferredSize(new Dimension(935, y+50 ));
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

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public JPanel getPanelTabelas() {
		return panelTabelas;
	}

	public JScrollPane getScrollFinanceiro() {
		return scrollFinanceiro;
	}

	public JTable getTabela() {
		return tabela;
	}

	public ArrayList<JScrollPane> getScrollPanes() {
		return scrollPanes;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public ArrayList<Parcela> getParcelas() {
		return parcelas;
	}

	public ArrayList<JTable> getTabelas() {
		return tabelas;
	}

}

package br.com.sistema_provedor_fbd_2018_1.view;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InternalServicos extends TelaInternal{
	private Botao btnNovo, btnEditar, btnRemover;
	private DefaultTableModel modelTable;
	private JScrollPane barraRolagem;
	private JTable tabela;
	private JTextField buscarField;
	private Botao btnBuscar;
	public InternalServicos(TelaPrincipal telaPrincipal, ActionListener actionListener) throws BusinessException {
		super("Serviços", telaPrincipal, actionListener);
		setBounds(150, 50, 1050, 510);
		getContentPane().setLayout(null);
	}

	@Override
	public void inicializar(){	
		btnEditar = new Botao("resource/imagens/botoes/editar-servico.png","Editar Serviço");
		btnEditar.setBounds(50, 20, 172, 40);
		getContentPane().add(btnEditar);

		btnNovo = new Botao("resource/imagens/botoes/adicionar-servico.png","Novo Serviço");
		btnNovo.setBounds(250, 20, 162, 40);
		getContentPane().add(btnNovo);

		btnRemover = new Botao("resource/imagens/botoes/remover-servico.png","Remover Serviço");
		btnRemover.setBounds(437, 20, 184, 40);
		getContentPane().add(btnRemover);

		modelTable = new DefaultTableModel();
		modelTable.addColumn("Id");
		modelTable.addColumn("Nome");
		modelTable.addColumn("Download");
		modelTable.addColumn("Upload");

		tabela = new JTable(modelTable);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
		tabela.getTableHeader().getColumnModel().getColumn(0).setMinWidth(100);
		tabela.setBounds(0,0,600,400);

		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(50,122,928,300);

		getContentPane().add(barraRolagem);
		
		buscarField = new JTextField();
		buscarField.setBounds(50, 71, 811, 40);
		getContentPane().add(buscarField);
		buscarField.setColumns(10);
		
		btnBuscar = new Botao("resource/imagens/botoes/btn-buscar.png","Buscar");
		btnBuscar.setBounds(871, 71, 107, 40);
		getContentPane().add(btnBuscar);
	}

	public void carregarServicos(List<Servico> servicos) {
		modelTable.setNumRows(0);
		for (Servico servico : servicos) {
			String[] linha = {servico.getId().toString(), servico.getNome(), String.valueOf(servico.getDownload()),String.valueOf(servico.getUpload())};
			modelTable.addRow(linha);
		}
	}

	public Botao getBtnNovo() {
		return btnNovo;
	}

	public Botao getBtnEditar() {
		return btnEditar;
	}

	public Botao getBtnRemover() {
		return btnRemover;
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

	public JTextField getBuscarField() {
		return buscarField;
	}

	public Botao getBtnBuscar() {
		return btnBuscar;
	}
	



}

package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TelaPrincipal extends Tela{
	private Menu menu;
	private BotaoDesktop btnAdicionarCliente;
	private BotaoDesktop btnVerCliente;
	private BotaoDesktop btnAdicionarSwitch;
	private BotaoDesktop btnAtendimentos;
	private BotaoDesktop btnMovimentacoes;
	private JLabel bgImage;
	private JDesktopPane desktopPane;
	private InternalCadastroCliente adicionarCliente;
	
	public TelaPrincipal() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 50,(int)tela.getWidth(),(int)tela.getHeight()-50);
		
		bgImage = new JLabel(new ImageIcon("resource/imagens/bg-app-main.jpg"));
		bgImage.setBounds(0, 0, desktopPane.getWidth(),(int) tela.getHeight());
		
		
		desktopPane.add(bgImage);
		getContentPane().add(desktopPane);	
		
		ImageIcon imagemTituloJanela = new ImageIcon("res/icon.png");
		setIconImage(imagemTituloJanela.getImage());
		
		setVisible(true);

	}
		
	@Override
	public void inicializar() {
		menu = new Menu();
		
		
		btnAdicionarCliente = new BotaoDesktop("resource/imagens/desktop/adicionarCliente.png","Adicionar Cliente");
		btnAdicionarCliente.setBounds(150,100,250,180);
		
		btnVerCliente = new BotaoDesktop("resource/imagens/desktop/verCliente.png", "Localizar Cliente");
		btnVerCliente.setBounds(550, 100, 250, 180);
		
		btnAdicionarSwitch = new BotaoDesktop("resource/imagens/desktop/adicionarSwitch.png", "Adicionar Switch");
		btnAdicionarSwitch.setBounds(950, 100, 250, 180);
		
		btnAtendimentos = new BotaoDesktop("resource/imagens/desktop/atendimento.png", "Atendimentos");
		btnAtendimentos.setBounds(350, 400, 250, 180);
		
		btnMovimentacoes = new BotaoDesktop("resource/imagens/desktop/movimentacao.png", "Movimentações");
		btnMovimentacoes.setBounds(750, 400, 250, 180);
		
		getContentPane().add(menu);
		getContentPane().add(btnAdicionarCliente);
		getContentPane().add(btnVerCliente);
		getContentPane().add(btnAdicionarSwitch);
		getContentPane().add(btnAtendimentos);
		getContentPane().add(btnMovimentacoes);
		
	}
	
	public void desativarBotoes() {
		btnAdicionarCliente.setVisible(false);
		btnVerCliente.setVisible(false);
		btnAdicionarSwitch.setVisible(false);
		btnAtendimentos.setVisible(false);
		btnMovimentacoes.setVisible(false);
	}
	
	public void ativarBotoes() {
			btnAdicionarCliente.setVisible(true);
			btnVerCliente.setVisible(true);
			btnAdicionarSwitch.setVisible(true);
			btnAtendimentos.setVisible(true);
			btnMovimentacoes.setVisible(true);
	}

	public Menu getMenu() {
		return menu;
	}

	public BotaoDesktop getBtnAdicionarCliente() {
		return btnAdicionarCliente;
	}

	public BotaoDesktop getBtnVerCliente() {
		return btnVerCliente;
	}

	public BotaoDesktop getBtnAdicionarSwitch() {
		return btnAdicionarSwitch;
	}

	public BotaoDesktop getBtnAtendimentos() {
		return btnAtendimentos;
	}

	public BotaoDesktop getBtnMovimentacoes() {
		return btnMovimentacoes;
	}

	public JLabel getBgImage() {
		return bgImage;
	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public InternalCadastroCliente getAdicionarCliente() {
		return adicionarCliente;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}

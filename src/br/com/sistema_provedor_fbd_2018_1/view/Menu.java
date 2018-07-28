package br.com.sistema_provedor_fbd_2018_1.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Menu extends JMenuBar{
	private JMenu cadastrosMenu, clientesMenu, netwokMenu, financeiroMenu;
	private JMenuItem funcionarioCadastro, servicoCadastro, cidadeCadastro;
	private JMenuItem adicionarCliente, verCliente, atendimentosCliente;
	private JMenuItem concentradorNetwork, switchNetwork, caixaNetwork;
	private JMenuItem movimentacoesFinanceiro;
	
	
	public Menu() {
		 Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	     int lar = (int) tela.getWidth();
	     setSize(lar, 50);
	     
	     inicializar();
	  
	}
	
	private void inicializar() {
		//Instanciando Menus
		cadastrosMenu = new JMenu("Cadastros");
		clientesMenu = new JMenu("Clientes");
		netwokMenu = new JMenu("Network");
		financeiroMenu = new JMenu("Financeiro");
		
		//Instanciando MenuItems
		funcionarioCadastro = new JMenuItem("Funcionario");
		servicoCadastro = new JMenuItem("Serviço");
		cidadeCadastro = new JMenuItem("Cidade");
		
		adicionarCliente = new JMenuItem("Adicionar Cliente");
		verCliente = new JMenuItem("Ver Cliente");
		atendimentosCliente = new JMenuItem("Atendimentos");
		
		
		concentradorNetwork = new JMenuItem("Concentrador");
		switchNetwork = new JMenuItem("Switch");
		caixaNetwork = new JMenuItem("Caixa");
		
		movimentacoesFinanceiro = new JMenuItem("Movimentações");
		
		
		//Adicionando Incone ao Menu
		cadastrosMenu.setIcon(new ImageIcon("resource/imagens/botoes/menu-toolbar.png"));
		clientesMenu.setIcon(new ImageIcon("resource/imagens/botoes/menu-toolbar.png"));
		netwokMenu.setIcon(new ImageIcon("resource/imagens/botoes/menu-toolbar.png"));
		financeiroMenu.setIcon(new ImageIcon("resource/imagens/botoes/menu-toolbar.png"));
		
		//Adicionando Incone ao MenuItem
		funcionarioCadastro.setIcon(new ImageIcon("resource/imagens/icones/icon-funcionario.png"));
		servicoCadastro.setIcon(new ImageIcon("resource/imagens/icones/icon-servico.png"));
		cidadeCadastro.setIcon(new ImageIcon("resource/imagens/icones/icon-cidade.png"));
		
		adicionarCliente.setIcon(new ImageIcon("resource/imagens/icones/icon-cliente.png"));
		verCliente.setIcon(new ImageIcon("resource/imagens/icones/icon-cliente.png"));
		atendimentosCliente.setIcon(new ImageIcon("resource/imagens/icones/icon-atendimento.png"));
		
		concentradorNetwork.setIcon(new ImageIcon("resource/imagens/icones/icon-concentrador.png"));
		switchNetwork.setIcon(new ImageIcon("resource/imagens/icones/icon-switch.png"));
		caixaNetwork.setIcon(new ImageIcon("resource/imagens/icones/icon-caixa.png"));
		
		movimentacoesFinanceiro.setIcon(new ImageIcon("resource/imagens/icones/icon-movimentacao.png"));
		
		
		//Adiconando MenusItens
		cadastrosMenu.add(funcionarioCadastro);
		cadastrosMenu.addSeparator();
		cadastrosMenu.add(servicoCadastro);
		cadastrosMenu.addSeparator();
		cadastrosMenu.add(cidadeCadastro);
		
		clientesMenu.add(verCliente);
		clientesMenu.addSeparator();
		clientesMenu.add(adicionarCliente);
		clientesMenu.addSeparator();
		clientesMenu.add(atendimentosCliente);
		clientesMenu.addSeparator();
		
		
		netwokMenu.add(concentradorNetwork);
		netwokMenu.addSeparator();
		netwokMenu.add(switchNetwork);
		netwokMenu.addSeparator();
		netwokMenu.add(caixaNetwork);
		
		financeiroMenu.add(movimentacoesFinanceiro);
		financeiroMenu.addSeparator();
		
		
		//Adicionando Menus
		add(cadastrosMenu);
		add(clientesMenu);
		add(netwokMenu);
		add(financeiroMenu);
	}

	public JMenu getCadastrosMenu() {
		return cadastrosMenu;
	}

	public JMenu getClientesMenu() {
		return clientesMenu;
	}

	public JMenu getNetwokMenu() {
		return netwokMenu;
	}

	public JMenu getFinanceiroMenu() {
		return financeiroMenu;
	}

	public JMenuItem getFuncionarioCadastro() {
		return funcionarioCadastro;
	}

	public JMenuItem getServicoCadastro() {
		return servicoCadastro;
	}

	public JMenuItem getAdicionarCliente() {
		return adicionarCliente;
	}

	public JMenuItem getVerCliente() {
		return verCliente;
	}

	public JMenuItem getAtendimentosCliente() {
		return atendimentosCliente;
	}

	public JMenuItem getConcentradorNetwork() {
		return concentradorNetwork;
	}

	public JMenuItem getSwitchNetwork() {
		return switchNetwork;
	}

	public JMenuItem getCaixaNetwork() {
		return caixaNetwork;
	}

	public JMenuItem getMovimentacoesFinanceiro() {
		return movimentacoesFinanceiro;
	}

	

	public JMenuItem getCidadeCadastro() {
		return cidadeCadastro;
	}

	
	
	

}

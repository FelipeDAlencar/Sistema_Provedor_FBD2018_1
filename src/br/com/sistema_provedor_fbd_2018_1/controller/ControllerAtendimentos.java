package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.model.Ultil;
import br.com.sistema_provedor_fbd_2018_1.view.InternalAtendimentos;
import br.com.sistema_provedor_fbd_2018_1.view.TelaPrincipal;

public class ControllerAtendimentos implements Listeners {
	private InternalAtendimentos internalAtendimentos;
	private TelaPrincipal  telaPrincipal;
	private Fachada fachada;

	public ControllerAtendimentos(TelaPrincipal telaPrincipal) {
		this.setTelaPrincipal(telaPrincipal);
		fachada = new Fachada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == internalAtendimentos.getBtnReagendarAtrasados()) {
				String dataAtual = Ultil.dataAtualEmString();
				
				ArrayList<Atendimento> atendimentos = fachada.buscarAtendimentosAtrasados(dataAtual);
				
				for (Atendimento atendimento : atendimentos) {
					atendimento.setData_atendimento(dataAtual);
					fachada.salvarOuEditarAtendimento(atendimento);
				}
				
				internalAtendimentos.carregarAtendimentos(fachada.listarTodosAtendimento());
				internalAtendimentos.carregarAtendimentosAtrasados(fachada.buscarAtendimentosAtrasados(dataAtual));
				
			}
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void addListeners() {
		internalAtendimentos.getBtnReagendarAtrasados().addActionListener(this);
	}

	public InternalAtendimentos getInternalAtendimentos() {
		return internalAtendimentos;
	}

	public void setInternalAtendimentos(InternalAtendimentos internalAtendimentos) {
		this.internalAtendimentos = internalAtendimentos;
	}

	public TelaPrincipal getTelaPrincipal() {
		return telaPrincipal;
	}

	public void setTelaPrincipal(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
	}

}

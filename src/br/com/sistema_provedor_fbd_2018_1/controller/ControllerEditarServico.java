package br.com.sistema_provedor_fbd_2018_1.controller;

import java.awt.event.ActionEvent;
import br.com.sistema_provedor_fbd_2018_1.entidade.Servico;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;
import br.com.sistema_provedor_fbd_2018_1.model.Listeners;
import br.com.sistema_provedor_fbd_2018_1.view.InternalEditarServico;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class ControllerEditarServico implements Listeners {
	private InternalEditarServico internalEditarServico;
	private Fachada fachada;
	private Servico servico;

	public ControllerEditarServico(Servico servico) {
		this.servico=servico;
		fachada = new Fachada();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource()==internalEditarServico.getBtnInserirServio()) {
				Servico servico = new Servico(
						this.servico.getId(),
						internalEditarServico.getServicoField().getText().trim(),
						Integer.parseInt(internalEditarServico.getDownloadField().getText().trim()),
						Integer.parseInt(internalEditarServico.getUploadField().getText().trim()));
				fachada.salvarOuEditarServico(servico);
				Menssagens.menssagem("SERVIÇO EDITADO COM SUCESSO",1);
			}
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void preencherCampos() {	
		internalEditarServico.getServicoField().setText(servico.getNome());
		internalEditarServico.getDownloadField().setText(String.valueOf(servico.getDownload()));
		internalEditarServico.getUploadField().setText(String.valueOf(servico.getUpload()));
	}

	@Override
	public void addListeners() {
		internalEditarServico.getBtnInserirServio().addActionListener(this);
	}

	public InternalEditarServico getInternalEditarServico() {
		return internalEditarServico;
	}

	public void setInternalEditarServico(InternalEditarServico internalEditarServico) {
		this.internalEditarServico = internalEditarServico;
	}

}

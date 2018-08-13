package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoAtendimento;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoAtendimento;
import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.exception.ValidacaoException;
import br.com.sistema_provedor_fbd_2018_1.model.Ultil;
import br.com.sistema_provedor_fbd_2018_1.view.Menssagens;

public class BusinessAtendimento implements IBusinessAtendimento {

	IDaoAtendimento dao;

	public BusinessAtendimento() {
		dao = new DaoAtendimento();
	}

	@Override
	public void salvarOuEditar(Atendimento atendimento) throws BusinessException {
		try {
			validacao(atendimento);
			if (atendimento.getId() == null) {
				dao.salvar(atendimento);
			} else {
				dao.editar(atendimento);
			}

		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	@Override
	public ArrayList<Atendimento> listarTodos() throws BusinessException {
		try {
			return dao.listarTodos();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("");
		}
	}

	@Override
	public Atendimento buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return dao.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("");
		}
	}

	@Override
	public ArrayList<Atendimento> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	private void validacao(Atendimento atendimento) throws ValidacaoException {
		
		Date dataInformada = Ultil.converterStringEmJavaDate(atendimento.getData_atendimento());
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(calendar.getTime());
		if(dataInformada.before(calendar.getTime())) {
			Menssagens.menssagem("Data informada é inferior a de hoje.", 2);
			throw new ValidacaoException("Data informada é inferior a de hoje.");
		}

	}

	@Override
	public ArrayList<Atendimento> buscarAtendimentosAtrasados(String data) throws BusinessException {
		try {
			return dao.buscarAtrasados(data);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("");
		}
	}

	@Override
	public List<Atendimento> buscarPorCliente(Integer cliente_id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return dao.buscarPorCliente(cliente_id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("");
		}
	}
}

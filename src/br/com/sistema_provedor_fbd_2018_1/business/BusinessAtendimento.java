package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoAtendimento;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoAtendimento;
import br.com.sistema_provedor_fbd_2018_1.entidade.Atendimento;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.exception.ValidacaoException;
import br.com.sistema_provedor_fbd_2018_1.model.Ultil;

public class BusinessAtendimento implements IBusinessAtendimento {

	IDaoAtendimento dao;

	public BusinessAtendimento() {
		dao = new DaoAtendimento();
	}

	@Override
	public void salvarOuEditar(Atendimento atendimento, String cpfCliente) throws BusinessException {
		try {
			validacao(atendimento);
			if (atendimento.getId() == null) {
				dao.salvar(atendimento, cpfCliente);
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
		return null;
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
}

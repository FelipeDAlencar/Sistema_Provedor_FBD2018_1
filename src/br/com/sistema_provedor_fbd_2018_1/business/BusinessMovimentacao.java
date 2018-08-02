package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoMovimentacao;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoMovimentacao;
import br.com.sistema_provedor_fbd_2018_1.entidade.Movimentacao;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public class BusinessMovimentacao implements IBusinessMovimentacao {

	private IDaoMovimentacao dao;

	public BusinessMovimentacao() {
		dao = new DaoMovimentacao();
	}

	@Override
	public void salvarOuEditar(Movimentacao movimentacao) throws BusinessException {
		try {
			validar(movimentacao);

			if (movimentacao.getId() == null) {
				dao.salvar(movimentacao);
			} else {
				dao.editar(movimentacao);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Erro no BUS");
		}

	}

	@Override
	public ArrayList<Movimentacao> listarTodos() throws BusinessException {
		try {
			return dao.listarTodos();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO NO BUS");
		}
	}

	@Override
	public Movimentacao buscarPorId(int id) throws BusinessException {
		try {
			return dao.buscarPorId(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO NO BUS");
		}
	}

	@Override
	public ArrayList<Movimentacao> buscarPorBusca(String busca, String situacao) throws BusinessException {

		try {
			return dao.buscarPorBusca(busca, situacao);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO NO BUS");
		}
	}

	public void validar(Movimentacao movimentacao) throws BusinessException {
		if (movimentacao.getDescricao().equals("") || movimentacao.getValor() == 0
				|| movimentacao.getData_movimentacao().equals("//")) {
			throw new BusinessException("PREENCHA OS CAMPOS DE DESCRIÇÃo, DATA E VALOR.");
		}
	}

	@Override
	public ArrayList<Movimentacao> buscarPagoOuNao(String busca) throws BusinessException {
		try {
			if (busca.equals("pago")) {

				return dao.buscarPago();

			} else if (busca.equals("Aguardando pagamento")) {
				return dao.buscarNaoPago();
			}
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("");
		}
		return null;
	}

}

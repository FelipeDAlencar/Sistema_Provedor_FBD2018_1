package br.com.sistema_provedor_fbd_2018_1.business;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoContato;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoContato;
import br.com.sistema_provedor_fbd_2018_1.entidade.Contato;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;

public class BusinessContato implements IBusinessContato {

	private IDaoContato dao;

	public BusinessContato() {
		dao = new DaoContato();
	}

	@Override
	public void salvarOuEditar(Contato contato, String cpfCliente) throws BusinessException {
		try {
			validacao();

			if (contato.getId() == null) {
				dao.salvar(contato, cpfCliente);
			} else {
				dao.editar(contato);
			}
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	private void validacao() {
		

	}
	public static boolean validar(String email)
    {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

	@Override
	public ArrayList<Contato> listarTodos() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contato buscarPorId(int id) throws BusinessException {
		try {
			return dao.buscarPorId(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO DE BUS");
		}
	}

	@Override
	public ArrayList<Contato> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> buscarPorCliente(Integer cliente_id) throws BusinessException {
		try {
			return dao.buscarPorCliente(cliente_id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO AO BUSCAR CONTATO - BUS");
		}
	}

}

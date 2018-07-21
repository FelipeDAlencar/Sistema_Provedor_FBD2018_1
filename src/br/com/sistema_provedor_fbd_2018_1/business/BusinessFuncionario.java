package br.com.sistema_provedor_fbd_2018_1.business;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.sistema_provedor_fbd_2018_1.dao.DaoFuncionario;
import br.com.sistema_provedor_fbd_2018_1.dao.IDaoFuncionario;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.entidade.Funcionario;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.exception.DaoException;
import br.com.sistema_provedor_fbd_2018_1.exception.ValidacaoException;

public class BusinessFuncionario implements IBusinessFuncionario {

	private IDaoFuncionario dao;

	public BusinessFuncionario() {
		dao = new DaoFuncionario();
	}

	@Override
	public void salvarOuEditarFuncionario(Funcionario funcionario) throws BusinessException {
		
		try {
			Validar(funcionario);
			if (funcionario.getId() == null) {
				
				dao.salvar(funcionario);
				
			} else {
				System.out.println(funcionario.getId());
				dao.editar(funcionario);
			}

		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Funcionario buscarPorId(int id)throws BusinessException {
		try {
			return dao.buscarPorId(id);
		} catch (DaoException e) {
			throw new BusinessException("ERRO NO BUS");
		}
	}

	@Override
	public Funcionario buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Funcionario> buscarPorBusca(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Funcionario> listarTodos()throws BusinessException {
		try {
			return dao.listarTodos();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException("ERRO DO BUS DE FUNCIONARIO");
		}
	}

	private void Validar(Funcionario funcionario) throws ValidacaoException {
		if (funcionario.getData_contrato().equals("") || funcionario.getLogin().equals("")
				|| funcionario.getSenha().equals("") || funcionario.getNome().equals("")
				|| funcionario.getCargo().equals("")) {
			throw new ValidacaoException("ERRO DE VALIDAÇÃO - PREENCHA OS CAMPOS NESCESSÁRIOS");

		}

	}

	public static Date converterParaData(String txt) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date data = null;

		data = new java.sql.Date(format.parse(txt).getTime());

		return data;

	}

}

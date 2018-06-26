package br.com.fbd_2018_1;

import br.com.sistema_provedor_fbd_2018_1.entidade.Cidade;
import br.com.sistema_provedor_fbd_2018_1.entidade.Cliente;
import br.com.sistema_provedor_fbd_2018_1.exception.BusinessException;
import br.com.sistema_provedor_fbd_2018_1.fachada.Fachada;

public class App {
	public static void main(String[] args) throws BusinessException {

		 Fachada fachada = new Fachada();
		//
		// Cidade cidade = fachada.buscarCidadePorId(2);

		// cidade.setCep("100000");
		// cidade.setNome("Serra Taiada");
		// cidade.setEstado("PE");
		
		// cidade.setNome("Serra Talhada");
		//
		// fachada.salvarOuEditarCidade(cidade);

		//System.out.println(fachada.buscarCidadePorId(9).getNome() + "\n");

		for (Cidade cidade2 : fachada.listarTodosCidades()) {
			System.out.println(cidade2.getNome());
		}

	}

}

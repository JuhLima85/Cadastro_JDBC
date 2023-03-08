package br.com.jls.teste;

import java.util.Date;

import br.com.jls.dao.CadastroDAO;
import br.com.jls.model.Cadastro;

public class Teste {

	public static void main(String[] args) {
		
		CadastroDAO cadDao = new CadastroDAO();
		
		// Salvar cadastro		
		Cadastro cadastro = new Cadastro();
		cadastro.setNome("Daniel sei lá das quantas");
		cadastro.setEndereco("Qd 03 conj 10 cs 05");
		cadastro.setTelefone("22222222");
		cadastro.setEmail("jessica@jls.com");
		cadastro.setDataCadastro(new Date());
		
		//cadDao.salvar(cadastro);
				
		// Detetar cadastro por id
		//cadDao.deletarPorId(10);		  
		 
		// Atualizar cadastro
		Cadastro c1 = new Cadastro();
		c1.setNome("Fernando sei lá das quantas");
		c1.setEndereco("Qd 03 conj 10 cs 03");
		c1.setTelefone("55555555");
		c1.setEmail("daniel@jls.com"); 
		c1.setId(11);
		
		//cadDao.atualizar(c1);		
						
		// Visualizer todos os registros do banco de dados
		for (Cadastro c : cadDao.ListarCadastro()) {
			//System.out.println("Cadastro "+ c.getId() + ": "+ c.getNome());			
		}
		
		// Visualizar um regestro especifico
		for (Cadastro c : cadDao.ListarCadastroPorNome("Andressa")) {
			System.out.println("Cadastro "+ c.getId() + ": "+ c.getNome());			
		}
	}
}

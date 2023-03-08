package br.com.jls.teste;

import br.com.jls.dao.CadastroDAO;

public class TesteDAO {

	public static void main(String[] args) {
		
		CadastroDAO cadDao = new CadastroDAO();
		cadDao.criarTabela();
		
		String sql = "INSERT INTO cadastro (nome, endereco, telefone, email, dataCadastro) VALUES (?, ?, ?, ?, ?)";
				
		System.out.println(cadDao.incluirAtributos(sql,"Julina Lima de Souza", 
				"Qd 03 conj 10 cs 01", "99999999", "andressa@jls.com", 2013/03/06));		
		System.out.println(cadDao.incluirAtributos(sql, "Andressa sei lá das quantas", 
				"Qd 03 conj 10 cs 01", "99999999", "andressa@jls.com", 2013/03/06));
		System.out.println(cadDao.incluirAtributos(sql, "Maria sei lá das quantas", 
				"Qd 03 conj 10 cs 02", "88888888", "maria@jls.com",2013/03/06));
		System.out.println(cadDao.incluirAtributos(sql, "Domingos sei lá das quantas", 
				"Qd 03 conj 10 cs 02", "77777777", "domingos@jls.com", 2013/03/06));
		System.out.println(cadDao.incluirAtributos(sql, "Nilcemar sei lá das quantas", 
				"Qd 03 conj 10 cs 03", "66666666", "nilcemar@jls.com", 2013/03/06));
		System.out.println(cadDao.incluirAtributos(sql, "Anderson sei lá das quantas", 
				"Qd 03 conj 10 cs 03", "55555555", "anderson@jls.com", 2013/03/06));
		System.out.println(cadDao.incluirAtributos(sql, "Bruna sei lá das quantas", 
				"Qd 03 conj 10 cs 04", "44444444", "bruna@jls.com", 2013/03/06));
		System.out.println(cadDao.incluirAtributos(sql, "Jéssica sei lá das quantas", 
				"Qd 03 conj 10 cs 04", "33333333", "jessica@jls.com", 2013/03/06));				
	
		cadDao.fecharConexao();

	}

}

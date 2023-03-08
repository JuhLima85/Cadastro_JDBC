package br.com.jls.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.jls.conexao.FabricaConexao;
import br.com.jls.model.Cadastro;

public class CadastroDAO {

	private Connection conexao;
	private PreparedStatement pst;

	public void salvar(Cadastro cadastro) {
		String sql = "INSERT INTO cadastro(nome, endereco, telefone, email, dataCadastro) VALUES (?, ?, ?, ?, ?)";

		try {
			conexao = FabricaConexao.getConexao();
			pst = conexao.prepareStatement(sql);

			pst.setString(1, cadastro.getNome());
			pst.setString(2, cadastro.getEndereco());
			pst.setString(3, cadastro.getTelefone());
			pst.setString(4, cadastro.getEmail());
			pst.setDate(5, new Date(cadastro.getDataCadastro().getTime()));

			pst.execute();
			fecharConexao();
			System.out.println("Cadastro salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pst != null) {
					pst.close();
				}				
			} catch ( Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deletarPorId(int id) {
		String sql = " DELETE FROM cadastro WHERE id = ?";
				
		try {
			conexao = FabricaConexao.getConexao();
			pst = conexao.prepareStatement(sql);
			pst.setInt(1, id);
			
			int contador = pst.executeUpdate();
			
			if (contador > 0) {
				System.out.println("Cadastro excluído com sucesso!");
			}else {
				System.out.println("Não há nada para excluir.");
			}
			
			System.out.println("Lihas afetadas: " + contador);
						
			fecharConexao();
						
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pst != null) {
					pst.close();
				}				
			} catch ( Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Cadastro> ListarCadastro() {
		
		String sql =  "Select * from cadastro";
		
		List<Cadastro> cadastros  = new ArrayList<>();
		
		ResultSet resultado = null;
		try {			
			
			conexao = FabricaConexao.getConexao();
			pst = conexao.prepareStatement(sql);
		 resultado = pst.executeQuery();
			while(resultado.next()) {
				Cadastro cadastro = new Cadastro();
				
				cadastro.setId(resultado.getInt("id"));
				cadastro.setNome(resultado.getString("nome"));
				cadastro.setEndereco(resultado.getString("endereco"));
				cadastro.setTelefone(resultado.getString("telefone"));
				cadastro.setEmail(resultado.getString("email"));
				cadastro.setDataCadastro(resultado.getDate("dataCadastro"));				
				
				cadastros.add(cadastro);				
			}				
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pst != null) {
					pst.close();
				}
				
				if (resultado != null) {
					resultado.close();
				}
								
			} catch ( Exception e) {
				e.printStackTrace();
			}
		}
		
		fecharConexao();
		return cadastros;
	}
	
	public List<Cadastro> ListarCadastroPorNome(String parteDoNOme) {
		
		String sql =  "SELECT * FROM cadastro WHERE nome like ?";
		
		List<Cadastro> cadastros  = new ArrayList<>();
		
		ResultSet resultado = null;
		try {			
			
			conexao = FabricaConexao.getConexao();
			pst = conexao.prepareStatement(sql);
			pst.setString(1, "%" + parteDoNOme + "%");		
			resultado = pst.executeQuery();
		 
			while(resultado.next()) {
				Cadastro cadastro = new Cadastro();
				
				cadastro.setId(resultado.getInt("id"));
				cadastro.setNome(resultado.getString("nome"));
				cadastro.setEndereco(resultado.getString("endereco"));
				cadastro.setTelefone(resultado.getString("telefone"));
				cadastro.setEmail(resultado.getString("email"));
				cadastro.setDataCadastro(resultado.getDate("dataCadastro"));				
				
				cadastros.add(cadastro);				
			}				
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pst != null) {
					pst.close();
				}
				
				if (resultado != null) {
					resultado.close();
				}				
				
			} catch ( Exception e) {
				e.printStackTrace();
			}
		}
		
		fecharConexao();
		return cadastros;
	}

	public void atualizar(Cadastro cadastro) {

		String sql = "UPDATE cadastro SET nome = ?, endereco = ?, telefone = ?, email = ?" + "WHERE id = ?";

		try {
			conexao = FabricaConexao.getConexao();

			pst = conexao.prepareStatement(sql);
			pst.setString(1, cadastro.getNome());
			pst.setString(2, cadastro.getEndereco());
			pst.setString(3, cadastro.getTelefone());
			pst.setString(4, cadastro.getEmail());
			pst.setInt(5, cadastro.getId());

			pst.executeUpdate();
			fecharConexao();
			System.out.println("Atualização criada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pst != null) {
					pst.close();
				}												
			} catch ( Exception e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void criarTabela() {
		conexao = FabricaConexao.getConexao();

		try {
			String sql = "CREATE TABLE IF NOT EXISTS cadastro"
					+ "(id int auto_increment primary key, nome varchar(82) not null, endereco varchar(150), telefone varchar(14), email varchar(100), dataCadastro DATE)";

			Statement stmt = conexao.createStatement();

			stmt.execute(sql);
			stmt.close();
			fecharConexao();
			System.out.println("Tabela criada com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConexao() {

		try {
			if (conexao != null && !conexao.isClosed()) {
				return conexao;
			}
		} catch (SQLException e) {

		}
		conexao = FabricaConexao.getConexao();
		return conexao;
	}

	public void fecharConexao() {
		try {
			getConexao().close();

		} catch (SQLException e) {

		} finally {
			conexao = null;
		}
	}
	/*
	 * Para facilar realização de teste, popula banco de dados com mais de um cadastro. Usado na classe DaoTeste.
	 */
	public int incluirAtributos(String sql, Object... atributos) {
		try {

			;
			PreparedStatement stmt = getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			adicionarAtributos(stmt, atributos);

			if (stmt.executeUpdate() > 0) {

				ResultSet resultado = stmt.getGeneratedKeys();

				if (resultado.next()) {
					return resultado.getInt(1);
				}
			}

			return -1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * Para facilar realização de teste, popula banco de dados com mais de um cadastro. Usado na classe DaoTeste.
	 */
	private void adicionarAtributos(PreparedStatement stmt, Object[] atributos) throws SQLException {

		int indice = 1;

		for (Object atributo : atributos) {

			if (atributo instanceof String) {
				stmt.setString(indice, (String) atributo);

			} else if (atributo instanceof Integer) {
				stmt.setInt(indice, (Integer) atributo);

			} else if (atributo instanceof Date) {
				stmt.setDate(indice, (Date) atributo);
			}

			indice++;
		}
	}
}

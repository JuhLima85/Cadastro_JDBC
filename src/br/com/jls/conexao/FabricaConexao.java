package br.com.jls.conexao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {

	/*
	 * Realiza a conexão
	 */
	public static Connection getConexao() {
		try {
			Properties prop = getProperties();

			final String url = prop.getProperty("banco.url");
			final String usuario = prop.getProperty("banco.usuario");
			final String senha = prop.getProperty("banco.senha");

			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException | IOException e) {

			throw new RuntimeException(e);
		}
	}

	/*
	 * Para consumir o arquivo properties
	 */
	private static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		String caminho = "/conexao.properties";

		prop.load(FabricaConexao.class.getResourceAsStream(caminho));

		return prop;
	}
	
	/*
	 * Verifica se tem conexões ativas
	 */
	private static void main(String[] args) throws Exception {
		Connection conexao = getConexao();
		
		if (conexao != null) {
			System.out.println("Conexão obtida com sucesso!");
			conexao.close();
		}
		
	}
}

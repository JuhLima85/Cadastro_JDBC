package br.com.jls.model;

import java.util.Date;
import java.util.Objects;

public class Cadastro {
	
	private int id;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private Date dataCadastro;
			
	public Cadastro() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public Cadastro(String nome, String endereco, String telefone, String email, Date dataCadastro) {
		super();
		
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.dataCadastro = dataCadastro;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Cadastro [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", email=" + email + ", dataCadastro=" + dataCadastro + "]";
	}
}

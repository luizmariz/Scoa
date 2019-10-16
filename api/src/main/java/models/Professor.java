package models;

import javax.persistence.Column;

public class Professor extends User {

	@Column(name="areaAtuacao")
	private String areaAtuacao;
	
	private String formacao;
	
	public Professor(String nome, String cpf, String email, String senha, String tipoUser, String areaAtuacao, String formacao) {
		super(nome, cpf, email, senha, tipoUser);
		this.areaAtuacao = areaAtuacao;
		this.formacao = formacao;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	
}

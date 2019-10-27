package com.fesg3.server.models;

import javax.persistence.Entity;

@Entity
public class Professor extends User {

	private String areaAtuacao;
	
	private String formacao;
	
	public Professor() {
	}
	
	public Professor(String nome, String cpf, String email, String senha, String areaAtuacao, String formacao) {
		super(nome, cpf, email, senha);
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

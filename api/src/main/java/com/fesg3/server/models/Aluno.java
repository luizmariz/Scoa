package com.fesg3.server.models;

import javax.persistence.Entity;

@Entity
public class Aluno extends User {

	private Long matricula;
	
	public Aluno() {
	}

	public Aluno(String nome, String cpf, String email, String senha, Long matricula) {
		super(nome, cpf, email, senha);
		this.matricula = matricula;
	}
	
	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	
}

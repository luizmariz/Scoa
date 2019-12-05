package com.fesg3.server.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends User {

	private Long matricula;
	
	@ManyToMany(mappedBy="aluno")
    private List<Turma> turma;
	
	@OneToMany(mappedBy="aluno")
	private List<Avaliacao> avaliacao;
	
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
	public List<Turma> getTurma() {
		return turma;
	}
	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}
	public List<Avaliacao> getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(List<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}
}

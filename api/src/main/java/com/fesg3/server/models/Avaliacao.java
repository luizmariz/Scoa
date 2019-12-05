package com.fesg3.server.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long avaliacao_id;
	
	private String data;
	
	private Long nota;
	
	@ManyToOne
	@JoinColumn(name="matricula_aluno")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="turma_id")
	private Turma turma;
	
	public Avaliacao() {
	}
	
	public Avaliacao(String data, Long nota) {
		this.data = data;
		this.nota = nota;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Long getNota() {
		return nota;
	}
	public void setNota(Long nota) {
		this.nota = nota;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno matricula_aluno) {
		this.aluno = matricula_aluno;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma_id) {
		this.turma = turma_id;
	}
}

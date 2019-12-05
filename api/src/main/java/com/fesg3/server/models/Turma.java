package com.fesg3.server.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long turma_id;
	
	private Long capacidade;
	
	private String periodo;
	
	@ManyToMany
    @JoinTable(name="turma_aluno", joinColumns=
    {@JoinColumn(name="turma_id")}, inverseJoinColumns=
      {@JoinColumn(name="matricula_aluno")})
    private List<Aluno> aluno;
		
	@ManyToOne
	@JoinColumn(name="classroom_id")
	private Classroom classroom;
	
	@OneToMany(mappedBy="turma")
	private List<Avaliacao> avaliacao;
	
	@ManyToOne
	@JoinColumn(name="dicipline_id")
	private Discipline discipline;
	
	public Turma() {
	}
	public Turma(Long capacidade) {
		this.capacidade = capacidade;
	}
	public Long getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Long capacidade) {
		this.capacidade = capacidade;
	}
	public List<Aluno> getAluno() {
		return aluno;
	}
	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public List<Avaliacao> getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(List<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Discipline getDiscipline() {
		return discipline;
	}
	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
}
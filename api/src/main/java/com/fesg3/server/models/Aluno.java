package com.fesg3.server.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Aluno extends User {

	private Long matricula;
	
	@ManyToMany(mappedBy="alunos")
    private List<Discipline> disciplinas;
	
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
	public List<Discipline> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Discipline> disciplinas) {
		this.disciplinas = disciplinas;
	}
}

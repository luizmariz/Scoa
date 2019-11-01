package com.fesg3.server.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Professor extends User {

	private String areaAtuacao;
	
	private String formacao;
	
	@ManyToMany
    @JoinTable(name="professor_discipline", joinColumns=
    {@JoinColumn(name="user_id")}, inverseJoinColumns=
      {@JoinColumn(name="discipline_id")})
    private List<Discipline> discipline;
	
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
	public List<Discipline> getDiscipline() {
		return discipline;
	}
	public void setDiscipline(List<Discipline> discipline) {
		this.discipline = discipline;
	}
}

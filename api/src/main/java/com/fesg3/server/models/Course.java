package com.fesg3.server.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long course_id;
	
	@NotBlank
	private String nome;
	
	@OneToMany(mappedBy="course")
	private List<Discipline> discipline;
	
	@OneToMany(mappedBy="course")
	private List<Professor> professor;

	public Course() {		
	}
	public Course(String nome){
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Discipline> getDiscipline() {
		return discipline;
	}
	public void setDiscipline(List<Discipline> discipline) {
		this.discipline = discipline;
	}
	public List<Professor> getProfessor() {
		return professor;
	}
	public void setProfessor(List<Professor> professor) {
		this.professor = professor;
	}
	
}
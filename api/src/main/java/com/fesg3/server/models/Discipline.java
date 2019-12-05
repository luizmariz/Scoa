package com.fesg3.server.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Discipline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long discipline_id;
	
	@NotBlank
	private String nome;
	
	private Long codigo;
	
	private Long creditos;
	
	private Long cargaHoraria;
	
	private String ementa;
	
	@ManyToMany(mappedBy="discipline")
    private List<Professor> professor;
	
	@OneToMany(mappedBy="discipline")
	private List<Turma> turma;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	public Discipline() {
	}
	
	public Discipline(String nome, Long adminId, Long codigo, Long creditos, Long cargaHoraria, String ementa){
		this.nome = nome;
		this.codigo = codigo;
		this.creditos = creditos;
		this.cargaHoraria = cargaHoraria;
		this.ementa = ementa;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Long getCreditos() {
		return creditos;
	}
	public void setCreditos(Long creditos) {
		this.creditos = creditos;
	}
	public Long getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Long cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	public List<Professor> getProfessor() {
		return professor;
	}
	public void setProfessor(List<Professor> professor) {
		this.professor = professor;
	}
	public List<Turma> getTurma() {
		return turma;
	}
	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
}
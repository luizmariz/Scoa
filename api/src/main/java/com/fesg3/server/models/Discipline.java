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
	
	@ManyToMany
    @JoinTable(name="discipline_aluno", joinColumns=
    {@JoinColumn(name="discipline_id")}, inverseJoinColumns=
      {@JoinColumn(name="matricula_aluno")})
    private List<Aluno> aluno;
	
	@ManyToMany(mappedBy="discipline")
    private List<Professor> professor;
		
	@ManyToOne
	@JoinColumn(name="classroom_id")
	private Classroom classroom;
	
	@OneToMany(mappedBy="discipline")
	private List<Avaliacao> avaliacao;
	
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
	public List<Aluno> getAluno() {
		return aluno;
	}
	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}
	public List<Professor> getProfessor() {
		return professor;
	}
	public void setProfessor(List<Professor> professor) {
		this.professor = professor;
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
	
}
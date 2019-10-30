package com.fesg3.server.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Discipline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDiscipline;
	
	@NotBlank
	private String nome;
	
	private Long adminId;
	
	private Long codigo;
	
	private Long creditos;
	
	private Long cargaHoraria;
	
	private String ementa;
	
	@ManyToMany
    @JoinTable(name="discipline_aluno", joinColumns=
    {@JoinColumn(name="idDiscipline")}, inverseJoinColumns=
      {@JoinColumn(name="matricula")})
    private List<Aluno> alunos;
	
	@ManyToMany(mappedBy="disciplinas")
    private List<Professor> professores;
	
	public Discipline() {
	}
	
	public Discipline(String nome, Long adminId, Long codigo, Long creditos, Long cargaHoraria, String ementa){
		this.nome = nome;
		this.adminId = adminId;
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
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	public List<?> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public List<Professor> getProfessores() {
		return professores;
	}
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
}
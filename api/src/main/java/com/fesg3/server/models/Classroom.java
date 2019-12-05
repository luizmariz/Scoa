package com.fesg3.server.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Classroom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long classroom_id;
	
	@NotBlank
	private String local;
	
	private Long capacidade;
	
	@OneToMany(mappedBy="classroom")
    private List<Turma> turma;
	
	public Classroom() {
	}
	public Classroom(String local, Long capacidade){
		this.local = local;
		this.capacidade = capacidade;
	}
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Long getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Long capacidade) {
		this.capacidade = capacidade;
	}
	public List<Turma> getTurma() {
		return turma;
	}
	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}
}

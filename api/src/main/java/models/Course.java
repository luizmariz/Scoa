package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Course {
	
	@Id
	@Column(name="idCurso")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCurso;
	
	@Column(name="nome")
	@NotBlank
	private String nome;
		
	public Course(Long idCurso, String nome){
		this.idCurso = idCurso;
		this.nome = nome;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}
	
}
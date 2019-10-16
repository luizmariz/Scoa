package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Classroom {
	
	@Id
	@Column(name="idSala")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSala;
	
	@Column(name="local")
	@NotBlank
	private String local;
	
	@Column(name="capacidade")
	@NotBlank
	private int capacidade;
	
	public Classroom(Long idSala, String local, int capacidade){
		this.idSala = idSala;
		this.local = local;
		this.capacidade = capacidade;
	}
	
	public Long getIdSala() {
		return idSala;
	}
	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
}

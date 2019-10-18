package com.fesg3.server.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Classroom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSala;
	
	private Long adminId;
	
	@NotBlank
	private String local;
	
	private Long capacidade;
	
	public Classroom() {
	}
	
	public Classroom(String local, Long capacidade, Long adminId){
		this.adminId = adminId;
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
	public Long getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Long capacidade) {
		this.capacidade = capacidade;
	}
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	
}

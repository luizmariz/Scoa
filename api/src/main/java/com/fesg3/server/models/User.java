package com.fesg3.server.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User{
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private Long password;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String email;
	
	public User() {	
	}
	
	public User(String username, Long password, String nome, String cpf, String email, String senha){
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getPassword() {
		return password;
	}
	public void setPassword(Long password) {
		this.password = password;
	}
}

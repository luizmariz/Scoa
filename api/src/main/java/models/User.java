package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public abstract class User {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String senha;
	
	@NotBlank
	private String tipoUser;
	
	public User(String nome, String cpf, String email, String senha, String tipoUser){
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.tipoUser = tipoUser;
	}
	public Long getIdUser() {
		return idUser;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipoUser() {
		return tipoUser;
	}
	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}

}

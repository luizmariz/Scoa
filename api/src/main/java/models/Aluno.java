package models;

import javax.persistence.Column;
import javax.persistence.Id;

public class Aluno extends User {

	@Id
	private Long matricula;

	public Aluno(String nome, String cpf, String email, String senha, String tipoUsuario, Long matricula) {
		super(nome, cpf, email, senha, tipoUsuario);
		this.matricula = matricula;
	}
	
	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	
}

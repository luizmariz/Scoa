package com.fesg3.server.models;

import javax.persistence.Entity;

@Entity
public class Administrador extends User{
	
	public Administrador() {
	}

	public Administrador(String username, Long password, String nome, String cpf, String email, String senha) {
		super();
	}
}

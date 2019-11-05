package com.fesg3.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fesg3.server.models.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long>{
	
	@Query("select u from Administrador u where u.nome = ?1")
	 Administrador findByName(String nome);
}

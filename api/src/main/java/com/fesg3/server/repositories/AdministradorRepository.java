package com.fesg3.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fesg3.server.models.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long>{
	
}

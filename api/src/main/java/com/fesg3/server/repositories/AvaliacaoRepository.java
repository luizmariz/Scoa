package com.fesg3.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fesg3.server.models.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
	
}

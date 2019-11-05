package com.fesg3.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fesg3.server.models.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long>{
	
	@Query("select u from Discipline u where u.nome = ?1")
	 Discipline findByName(String nome);
	
}

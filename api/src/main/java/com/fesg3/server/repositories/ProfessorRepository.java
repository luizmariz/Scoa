package com.fesg3.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fesg3.server.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	
	@Query("select u from Professor u where u.nome = ?1")
	 Professor findByName(String nome);
	
}

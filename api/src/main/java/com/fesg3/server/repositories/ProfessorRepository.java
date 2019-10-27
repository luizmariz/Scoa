package com.fesg3.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fesg3.server.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	
}

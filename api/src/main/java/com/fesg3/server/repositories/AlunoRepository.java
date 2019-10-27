package com.fesg3.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fesg3.server.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
}

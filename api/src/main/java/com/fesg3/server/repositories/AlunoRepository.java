package com.fesg3.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fesg3.server.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	 @Query("select u from Aluno u where u.nome = ?1")
	 Aluno findByName(String nome);
	 
}

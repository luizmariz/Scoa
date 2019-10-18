package com.fesg3.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fesg3.server.models.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long>{

}

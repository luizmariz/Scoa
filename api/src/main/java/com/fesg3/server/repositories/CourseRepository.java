package com.fesg3.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fesg3.server.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

	@Query("select u from Course u where u.nome = ?1")
	 Course findByName(String nome);
	
}

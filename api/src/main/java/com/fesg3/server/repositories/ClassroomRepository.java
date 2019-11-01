package com.fesg3.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fesg3.server.models.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long>{

}

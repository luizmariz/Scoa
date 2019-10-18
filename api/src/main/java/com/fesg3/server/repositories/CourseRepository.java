package com.fesg3.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fesg3.server.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}

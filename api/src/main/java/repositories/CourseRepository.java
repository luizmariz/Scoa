package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}

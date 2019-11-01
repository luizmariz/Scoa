package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long>{

}

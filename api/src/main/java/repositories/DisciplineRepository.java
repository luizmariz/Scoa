package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long>{

}

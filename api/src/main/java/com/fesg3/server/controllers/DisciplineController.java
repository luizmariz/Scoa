package com.fesg3.server.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fesg3.server.models.Discipline;
import com.fesg3.server.repositories.DisciplineRepository;

@RestController
@RequestMapping({"/discipline"})
public class DisciplineController {
	
	private DisciplineRepository repository;
	
	DisciplineController(DisciplineRepository disciplineRepository) {
		this.repository = disciplineRepository;
	}
	
	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{discipline_id}"})
	public ResponseEntity<?> findById(@PathVariable Long discipline_id){
	   return repository.findById(discipline_id)
			   .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Discipline create(@RequestBody Discipline discipline){
	   return repository.save(discipline);
	}
	
	@PutMapping(value="/{discipline_id}")
	public ResponseEntity<Discipline> update(@PathVariable("discipline_id") Long discipline_id,
	                                      @RequestBody Discipline discipline) {
	   return repository.findById(discipline_id)
	           .map(record -> {
	               record.setNome(discipline.getNome());
	               record.setCodigo(discipline.getCodigo());
	               record.setCreditos(discipline.getCreditos());
	               record.setCargaHoraria(discipline.getCargaHoraria());
	               record.setEmenta(discipline.getEmenta());
	               record.setAluno(discipline.getAluno());
	               record.setProfessor(discipline.getProfessor());
	               record.setClassroom(discipline.getClassroom());
	               record.setAvaliacao(discipline.getAvaliacao());
	               Discipline updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{discipline_id}"})
	public ResponseEntity<?> delete(@PathVariable Long discipline_id) {
	   return repository.findById(discipline_id)
	           .map(record -> {
	               repository.deleteById(discipline_id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
}

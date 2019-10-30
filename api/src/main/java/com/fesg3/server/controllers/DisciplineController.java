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
	
	@GetMapping(path = {"/{idDiscipline}"})
	public ResponseEntity<?> findById(@PathVariable Long idDiscipline){
	   return repository.findById(idDiscipline)
			   .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Discipline create(@RequestBody Discipline discipline){
	   return repository.save(discipline);
	}
	
	@PutMapping(value="/{idDiscipline}")
	public ResponseEntity<Discipline> update(@PathVariable("idDiscipline") Long idDiscipline,
	                                      @RequestBody Discipline discipline) {
	   return repository.findById(idDiscipline)
	           .map(record -> {
	               record.setNome(discipline.getNome());
	               record.setAdminId(discipline.getAdminId());
	               record.setCodigo(discipline.getCodigo());
	               record.setCreditos(discipline.getCreditos());
	               record.setCargaHoraria(discipline.getCargaHoraria());
	               record.setEmenta(discipline.getEmenta());
	               Discipline updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{idDiscipline}"})
	public ResponseEntity<?> delete(@PathVariable Long idDiscipline) {
	   return repository.findById(idDiscipline)
	           .map(record -> {
	               repository.deleteById(idDiscipline);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
}

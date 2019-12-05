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

import com.fesg3.server.models.Turma;
import com.fesg3.server.repositories.TurmaRepository;

@RestController
@RequestMapping({"/turma"})
public class TurmaController {
	
	private TurmaRepository repository;
	
	TurmaController(TurmaRepository turmaRepository) {
		this.repository = turmaRepository;
	}
	
	@GetMapping
	public List<Turma> findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{turma_id}"})
	public ResponseEntity<?> findById(@PathVariable Long turma_id){
	   return repository.findById(turma_id)
			   .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Turma create(@RequestBody Turma turma){
	   return repository.save(turma);
	}
	
	@PutMapping(value="/{turma_id}")
	public ResponseEntity<Turma> update(@PathVariable("turma_id") Long turma_id,
	                                      @RequestBody Turma turma) {
	   return repository.findById(turma_id)
	           .map(record -> {
	               record.setCapacidade(turma.getCapacidade());
	               record.setAluno(turma.getAluno());
	               record.setClassroom(turma.getClassroom());
	               record.setAvaliacao(turma.getAvaliacao());
	               record.setDiscipline(turma.getDiscipline());
	               Turma updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{turma_id}"})
	public ResponseEntity<?> delete(@PathVariable Long turma_id) {
	   return repository.findById(turma_id)
	           .map(record -> {
	               repository.deleteById(turma_id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
}

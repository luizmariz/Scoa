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

import com.fesg3.server.models.Professor;
import com.fesg3.server.repositories.ProfessorRepository;

@RestController
@RequestMapping({"/professor"})
public class ProfessorController {
	
	private ProfessorRepository repository;
	
	ProfessorController(ProfessorRepository ProfessorRepository) {
		this.repository = ProfessorRepository;
	}
	
	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{idProfessor}"})
	public ResponseEntity<?> findById(@PathVariable Long idUser){
	   return repository.findById(idUser)
			   .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Professor create(@RequestBody Professor Professor){
	   return repository.save(Professor);
	}
	
	@PutMapping(path="/{idProfessor}")
	public ResponseEntity<Professor> update(@PathVariable("idProfessor") Long idUser,
	                                      @RequestBody Professor Professor) {
	   return repository.findById(idUser)
	           .map(record -> {
	               record.setNome(Professor.getNome());
	               record.setCpf(Professor.getCpf());
	               record.setEmail(Professor.getEmail());
	               record.setSenha(Professor.getSenha());
	               record.setAreaAtuacao(Professor.getAreaAtuacao());
	               record.setFormacao(Professor.getFormacao());
	               Professor updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{idProfessor}"})
	public ResponseEntity<?> delete(@PathVariable("idProfessor") Long idUser) {
	   return repository.findById(idUser)
	           .map(record -> {
	               repository.deleteById(idUser);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
}

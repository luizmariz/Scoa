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

import com.fesg3.server.models.Aluno;
import com.fesg3.server.repositories.AlunoRepository;

@RestController
@RequestMapping({"/aluno"})
public class AlunoController {
	
	private AlunoRepository repository;
	
	AlunoController(AlunoRepository AlunoRepository) {
		this.repository = AlunoRepository;
	}
	
	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{idAluno}"})
	public ResponseEntity<?> findById(@PathVariable Long idAluno){
	   return repository.findById(idAluno)
			   .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Aluno create(@RequestBody Aluno Aluno){
	   return repository.save(Aluno);
	}
	
	@PutMapping(path="/{idAluno}")
	public ResponseEntity<Aluno> update(@PathVariable("idAluno") Long idUser,
	                                      @RequestBody Aluno Aluno) {
	   return repository.findById(idUser)
	           .map(record -> {
	               record.setNome(Aluno.getNome());
	               record.setCpf(Aluno.getCpf());
	               record.setEmail(Aluno.getEmail());
	               record.setSenha(Aluno.getSenha());
	               record.setMatricula(Aluno.getMatricula());
	               Aluno updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{idAluno}"})
	public ResponseEntity<?> delete(@PathVariable("idAluno") Long idUser) {
	   return repository.findById(idUser)
	           .map(record -> {
	               repository.deleteById(idUser);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
}

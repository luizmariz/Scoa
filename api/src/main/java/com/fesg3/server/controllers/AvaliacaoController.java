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

import com.fesg3.server.models.Avaliacao;
import com.fesg3.server.repositories.AvaliacaoRepository;

@RestController
@RequestMapping({"/avaliacao"})
public class AvaliacaoController {
	
	private AvaliacaoRepository repository;
	
	AvaliacaoController(AvaliacaoRepository AvaliacaoRepository) {
		this.repository = AvaliacaoRepository;
	}
	
	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{avaliacao_id}"})
	public ResponseEntity<?> findById(@PathVariable("avaliacao_id") Long avaliacao_id){
	   return repository.findById(avaliacao_id)
			   .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Avaliacao create(@RequestBody Avaliacao Avaliacao){
	   return repository.save(Avaliacao);
	}
	
	@PutMapping(path="/{avaliacao_id}")
	public ResponseEntity<Avaliacao> update(@PathVariable("avaliacao_id") Long idUser,
	                                      @RequestBody Avaliacao Avaliacao) {
	   return repository.findById(idUser)
	           .map(record -> {
	               record.setData(Avaliacao.getData());
	               record.setNota(Avaliacao.getNota());
	               record.setAluno(Avaliacao.getAluno());
	               record.setDiscipline(Avaliacao.getDiscipline());
	               Avaliacao updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{avaliacao_id}"})
	public ResponseEntity<?> delete(@PathVariable("avaliacao_id") Long idUser) {
	   return repository.findById(idUser)
	           .map(record -> {
	               repository.deleteById(idUser);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
}

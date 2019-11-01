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

import com.fesg3.server.models.Administrador;
import com.fesg3.server.repositories.AdministradorRepository;

@RestController
@RequestMapping({"/administrador"})
public class AdministradorController {
	
	private AdministradorRepository repository;
	
	AdministradorController(AdministradorRepository AdministradorRepository) {
		this.repository = AdministradorRepository;
	}
	
	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{user_id}"})
	public ResponseEntity<?> findById(@PathVariable Long idUser){
	   return repository.findById(idUser)
			   .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Administrador create(@RequestBody Administrador Administrador){
	   return repository.save(Administrador);
	}
	
	@PutMapping(path="/{user_id}")
	public ResponseEntity<Administrador> update(@PathVariable("user_id") Long idUser,
	                                      @RequestBody Administrador Administrador) {
	   return repository.findById(idUser)
	           .map(record -> {
	               record.setNome(Administrador.getNome());
	               record.setCpf(Administrador.getCpf());
	               record.setEmail(Administrador.getEmail());
	               record.setSenha(Administrador.getSenha());
	               Administrador updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{user_id}"})
	public ResponseEntity<?> delete(@PathVariable("user_id") Long idUser) {
	   return repository.findById(idUser)
	           .map(record -> {
	               repository.deleteById(idUser);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
}

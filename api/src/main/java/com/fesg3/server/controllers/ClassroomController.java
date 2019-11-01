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

import com.fesg3.server.models.Classroom;
import com.fesg3.server.repositories.ClassroomRepository;

@RestController
@RequestMapping({"/classroom"})
public class ClassroomController {
	
	private ClassroomRepository repository;
	
	ClassroomController(ClassroomRepository classroomRepository) {
		this.repository = classroomRepository;
	}
	
	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{classroom_id}"})
	public ResponseEntity<?> findById(@PathVariable Long classroom_id){
	   return repository.findById(classroom_id)
			   .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Classroom create(@RequestBody Classroom classroom){
	   return repository.save(classroom);
	}
	
	@PutMapping(value="/{classroom_id}")
	public ResponseEntity<Classroom> update(@PathVariable("classroom_id") Long classroom_id,
	                                      @RequestBody Classroom classroom) {
	   return repository.findById(classroom_id)
	           .map(record -> {
	               record.setLocal(classroom.getLocal());
	               record.setCapacidade(classroom.getCapacidade());
	               record.setDiscipline(classroom.getDiscipline());
	               Classroom updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{classroom_id}"})
	public ResponseEntity<?> delete(@PathVariable Long classroom_id) {
	   return repository.findById(classroom_id)
	           .map(record -> {
	               repository.deleteById(classroom_id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
}

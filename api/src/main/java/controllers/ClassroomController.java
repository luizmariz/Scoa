package controllers;

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

import models.Classroom;
import models.User;
import repositories.ClassroomRepository;

@RestController
@RequestMapping({"/classroom"})
public class ClassroomController {
	
	private ClassroomRepository repository;
	
	ClassroomController(ClassroomRepository classroomRepository) {
		this.repository = classroomRepository;
	}
	
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{idSala}"})
	public ResponseEntity findById(@PathVariable Long idSala){
	   return repository.findById(idSala)
			   .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Classroom create(@RequestBody Classroom classroom){
	   return repository.save(classroom);
	}
	
	@PutMapping(value="/{idSala}")
	public ResponseEntity update(@PathVariable("idSala") Long idSala,
	                                      @RequestBody Classroom classroom) {
	   return repository.findById(idSala)
	           .map(record -> {
	               record.setLocal(classroom.getLocal());
	               record.setCapacidade(classroom.getCapacidade());
	               Classroom updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{idSala}"})
	public ResponseEntity<?> delete(@PathVariable Long idSala) {
	   return repository.findById(idSala)
	           .map(record -> {
	               repository.deleteById(idSala);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
}

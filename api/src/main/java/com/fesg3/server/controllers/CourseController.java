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

import com.fesg3.server.models.Course;
import com.fesg3.server.repositories.CourseRepository;

@RestController
@RequestMapping({"/course"})
public class CourseController {
	
	private CourseRepository repository;
	
	CourseController(CourseRepository courseRepository) {
		this.repository = courseRepository;
	}
	
	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{idCurso}"})
	public ResponseEntity<?> findById(@PathVariable Long idCurso){
	   return repository.findById(idCurso)
			   .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Course create(@RequestBody Course course){
	   return repository.save(course);
	}
	
	@PutMapping(value="/{idCurso}")
	public ResponseEntity<Course> update(@PathVariable("idCurso") Long idCurso,
	                                      @RequestBody Course course) {
	   return repository.findById(idCurso)
	           .map(record -> {
	               record.setNome(course.getNome());
	               record.setAdminId(course.getAdminId());
	               Course updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{idCurso}"})
	public ResponseEntity<?> delete(@PathVariable Long idCurso) {
	   return repository.findById(idCurso)
	           .map(record -> {
	               repository.deleteById(idCurso);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
}

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
	
	@GetMapping(path = {"/{course_id}"})
	public ResponseEntity<?> findById(@PathVariable Long course_id){
	   return repository.findById(course_id)
			   .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Course create(@RequestBody Course course){
	   return repository.save(course);
	}
	
	@PutMapping(value="/{course_id}")
	public ResponseEntity<Course> update(@PathVariable("course_id") Long course_id,
	                                      @RequestBody Course course) {
	   return repository.findById(course_id)
	           .map(record -> {
	               record.setNome(course.getNome());
	               Course updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{course_id}"})
	public ResponseEntity<?> delete(@PathVariable Long course_id) {
	   return repository.findById(course_id)
	           .map(record -> {
	               repository.deleteById(course_id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
}

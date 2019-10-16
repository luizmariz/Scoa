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

import models.User;
import repositories.UserRepository;

@RestController
@RequestMapping({"/user"})
public class UserController {
	
	private UserRepository repository;
	
	UserController(UserRepository userRepository) {
		this.repository = userRepository;
	}
	
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{idUser}"})
	public ResponseEntity findById(@PathVariable Long idUser){
	   return repository.findById(idUser)
			   .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public User create(@RequestBody User user){
	   return repository.save(user);
	}
	
	@PutMapping(value="/{idUser}")
	public ResponseEntity update(@PathVariable("idUser") Long idUser,
	                                      @RequestBody User user) {
	   return repository.findById(idUser)
	           .map(record -> {
	               record.setNome(user.getNome());
	               record.setCpf(user.getCpf());
	               record.setEmail(user.getEmail());
	               record.setSenha(user.getSenha());
	               record.setTipoUser(user.getTipoUser());
	               User updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{idUser}"})
	public ResponseEntity<?> delete(@PathVariable Long idUser) {
	   return repository.findById(idUser)
	           .map(record -> {
	               repository.deleteById(idUser);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
}

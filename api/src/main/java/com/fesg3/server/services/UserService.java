package com.fesg3.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fesg3.server.models.User;
import com.fesg3.server.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository ur;
	
	public List<User> listAll(){
		return ur.findAll();
	}
	
	public void save(User user) {
		ur.save(user);
	}
	
	public User get(Long id) {
		return ur.findById(id).get();
	}
	
	public void delete(Long id) {
		ur.deleteById(id);
	}
}

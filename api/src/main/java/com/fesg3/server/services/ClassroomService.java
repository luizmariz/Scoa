package com.fesg3.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fesg3.server.models.Classroom;
import com.fesg3.server.repositories.ClassroomRepository;


@Service
public class ClassroomService {
	@Autowired
	private ClassroomRepository cr;
	
	public List<Classroom> listAll(){
		return cr.findAll();
	}
	
	public void save(Classroom classroom) {
		cr.save(classroom);
	}
	
	public Classroom get(Long id) {
		return cr.findById(id).get();
	}
	
	public void delete(Long id) {
		cr.deleteById(id);
	}
}

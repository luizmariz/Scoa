package com.fesg3.server.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fesg3.server.models.Discipline;
import com.fesg3.server.repositories.DisciplineRepository;

@Service
public class DisciplineService {
	@Autowired
	private DisciplineRepository dr;
	
	public List<Discipline> listAll(){
		return dr.findAll();
	}
	
	public void save(Discipline discipline) {
		dr.save(discipline);
	}
	
	public Discipline get(Long id) {
		return dr.findById(id).get();
	}
	
	public void delete(Long id) {
		dr.deleteById(id);
	}
}

package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Course;
import repositories.CourseRepository;


@Service
public class CourseService {
	@Autowired
	private CourseRepository cor;
	
	public List<Course> listAll(){
		return cor.findAll();
	}
	
	public void save(Course course) {
		cor.save(course);
	}
	
	public Course get(Long id) {
		return cor.findById(id).get();
	}
	
	public void delete(Long id) {
		cor.deleteById(id);
	}
}

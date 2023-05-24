package com.ninja.beltexam.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ninja.beltexam.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
	
	public List<Course> findAll();
	
	public Optional<Course> findById(Long id);
	
	public void deleteById(Long id);
}
